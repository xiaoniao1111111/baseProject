package com.excel.service;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.excel.mapper.ResourceMapper;
import com.excel.mapper.UserMapper;
import com.excel.pojo.Resource;
import com.excel.pojo.User;
import com.excel.util.ExcelParser;
import com.leyou.util.DateUtils;
import com.leyou.util.EntityUtils;
import com.leyou.util.ExcelUtils;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HikariDataSource hikariDataSource;
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * excel 简单导出
     *
     * @param response
     */
    @Override
    public void export(HttpServletResponse response) {
        // 1.获取全量的用户信息
        List<User> users = userMapper.selectAll();
        // 2.导出
        userExport(users, response);
    }

    /**
     * excel 简单导入
     *
     * @param file
     */
    @Override
    public void excelImport(MultipartFile file) {
        try {
            Workbook wb = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = wb.getSheetAt(0);
            // 获取最后一行的索引值
            int lastRowNum = sheet.getLastRowNum();
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (int rowIndex = 0; rowIndex < lastRowNum; rowIndex++) {
                User user = new User();
                Row row = sheet.getRow(rowIndex + 1);
                Cell cell0 = row.getCell(0);
                String value = ExcelUtils.getValue(cell0, evaluator);

                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                Cell cell3 = row.getCell(3);
                Cell cell4 = row.getCell(4);
                Cell cell5 = row.getCell(5);
                Cell cell6 = row.getCell(6);
                Cell cell7 = row.getCell(7);
                Cell cell8 = row.getCell(8);
                Cell cell9 = row.getCell(9);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 百万数据的导出 1、肯定使用高版本的excel 2、使用sax方式解析Excel（XML）
     * 限制：1、不能使用模板 2、不能使用太多的样式
     *
     * @param response
     */
    public void exportMillion(HttpServletResponse response) {
//        指定使用的是sax方式解析
        Workbook workbook = new SXSSFWorkbook();  //sax方式就是逐行解析
//        Workbook workbook = new XSSFWorkbook(); //dom4j的方式
//        导出500W条数据 不可能放到同一个sheet中 规定：每个sheet不能超过100W条数据
        int page = 1;
        int num = 0;// 记录了处理数据的个数
        int rowIndex = 1; //记录的是每个sheet的行索引
        Row row = null;
        Sheet sheet = null;
        while (true) {
            List<User> userList = userService.findPage(page, 100000);
            if (CollectionUtils.isEmpty(userList)) {
                break; //用户数据为空 跳出循环
            }
//           0   1000000  2000000  3000000  4000000  5000000
            if (num % 1000000 == 0) {  //表示应该创建新的标题
                sheet = workbook.createSheet("第" + ((num / 1000000) + 1) + "个工作表");
                rowIndex = 1; //每个sheet中的行索引重置
//            设置小标题
//            编号	姓名	手机号	入职日期	现住址
                String[] titles = new String[]{"编号", "姓名", "手机号", "入职日期", "现住址"};
                Row titleRow = sheet.createRow(0);
                for (int i = 0; i < 5; i++) {
                    titleRow.createCell(i).setCellValue(titles[i]);
                }
            }
            for (User user : userList) {
                row = sheet.createRow(rowIndex);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getUserName());
                row.createCell(2).setCellValue(user.getPhone());
                row.createCell(3).setCellValue(DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD));
                row.createCell(4).setCellValue(user.getAddress());

                rowIndex++;
                num++;
            }
            page++; //当前页码加1
        }

        String filename = "百万用户数据的导出.xlsx";
        ExcelUtils.export(response, workbook, filename);
    }

    /**
     * 使用csv文件导出百万数据
     */
    public void exportCSV(HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            String filename = "百万用户数据的导出.csv";
            response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes(), "ISO8859-1"));
            response.setContentType("text/csv");
            CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, "utf-8"));
//        写入了小标题数据
            String[] titles = new String[]{"编号", "姓名", "手机号", "入职日期", "现住址"};
            csvWriter.writeNext(titles);

            int page = 1;
            while (true) {
                List<User> userList = userService.findPage(page, 200000);
                if (CollectionUtils.isEmpty(userList)) {
                    break;
                }
                for (User user : userList) {
                    csvWriter.writeNext(new String[]{user.getId().toString(), user.getUserName(),
                            user.getPhone(), DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD), user.getAddress()});
                }
                page++;
                csvWriter.flush();
            }
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载用户的合同文档
     */
    public void exportContract(Long id, HttpServletResponse response) {
        try {
            //        1、读取到模板
            File rootFile = new File(ResourceUtils.getURL("classpath:").getPath()); //获取项目的根目录
            File templateFile = new File(rootFile, "/word_template/contract_template.docx");
            XWPFDocument word = new XWPFDocument(new FileInputStream(templateFile));
//        2、查询当前用户User--->map
            User user = userService.findById(id);
            Map<String, String> params = new HashMap<>();
            params.put("userName", user.getUserName());
            params.put("hireDate", DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD));
            params.put("address", user.getAddress());
//        3、替换数据
//         处理正文开始
            List<XWPFParagraph> paragraphs = word.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    for (String key : params.keySet()) {
                        if (text.contains(key)) {
                            run.setText(text.replaceAll(key, params.get(key)), 0);
                        }
                    }
                }
            }
//         处理正文结束

//      处理表格开始     名称	价值	是否需要归还	照片
            List<Resource> resourceList = user.getResourceList(); //表格中需要的数据
            XWPFTable xwpfTable = word.getTables().get(0);

            XWPFTableRow row = xwpfTable.getRow(0);
            int rowIndex = 1;
            for (Resource resource : resourceList) {
                // 深拷贝行
                copyRow(xwpfTable, row, rowIndex);
                XWPFTableRow row1 = xwpfTable.getRow(rowIndex);
                row1.getCell(0).setText(resource.getName());
                row1.getCell(1).setText(resource.getPrice().toString());
                row1.getCell(2).setText(resource.getNeedReturn() ? "需求" : "不需要");

                File imageFile = new File(rootFile, "/static" + resource.getPhoto());
                setCellImage(row1.getCell(3), imageFile);
                rowIndex++;
            }
//     处理表格开始结束
//        4、导出word
            String filename = "员工(" + user.getUserName() + ")合同.docx";
            response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes(), "ISO8859-1"));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            word.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel poi 导出用户数据到PDF中
     *
     * @param response
     */
    public void exportPDF(HttpServletResponse response) {
        try {
            //        1、获取模板文件
            File rootFile = new File(ResourceUtils.getURL("classpath:").getPath()); //获取项目的根目录
            File templateFile = new File(rootFile, "/pdf_template/userList2.jasper");
//       2、准备数据库的链接
            Map params = new HashMap();
            Example example = new Example(User.class);
            example.setOrderByClause("province");
            List<User> userList = userMapper.selectByExample(example);
//        给userList中的每个user赋hireDateStr的值
            userList = userList.stream().map(user -> {
                user.setHireDateStr(DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD));
                return user;
            }).collect(Collectors.toList());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(userList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params, dataSource);

            ServletOutputStream outputStream = response.getOutputStream();
            String filename = "用户列表数据.pdf";
            response.setContentType("application/pdf");
            response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes(), "iso8859-1"));

            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel poi 导入百万数据
     *
     * @param file
     */
    @Override
    public void importMillion(MultipartFile file) {
        try {
            File file1 = new File(ResourceUtils.getURL("classpath:").getPath() + "/" + file.getOriginalFilename());
            file.transferTo(file1);
            new ExcelParser().parse(file1.getAbsolutePath());
            file1.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * excel poi 使用csv文件导入百万数据
     *
     * @param file
     */
    @Override
    public void importCSV(MultipartFile file) {
        try {
            File file1 = new File(ResourceUtils.getURL("classpath:").getPath() + "/" + file.getOriginalFilename());
            file.transferTo(file1);
            CSVReader csvReader = new CSVReader(new FileReader(file1.getAbsolutePath()));
            String[] titles = csvReader.readNext(); //读取到第一行 是小标题
//        "编号","姓名","手机号","入职日期","现住址"
            User user = null;
            while (true) {
                user = new User();
                String[] content = csvReader.readNext();
                if (content == null) {
                    break;
                }
                user.setId(Long.parseLong(content[0]));
                user.setUserName(content[1]);
                user.setPhone(content[2]);
                user.setHireDate(DateUtils.stringToDate(content[3], DateUtils.FORMAT_YYYY_MM_DD));
                user.setAddress(content[4]);
                System.out.println(user);
                // 删除临时文件
                file1.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 导出多个sheet页
     *
     * @param response
     */
    @Override
    public void exportMoreSheet(HttpServletResponse response) {
        // 创建工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        // 构造样式
        Map<String, HSSFCellStyle> styleMap = ExcelUtils.tectonicStyle(wb);
        // 组装sheet名称
        String[] sheetNames = new String[]{"用户信息明细导出", "用品明细导出"};
        // 组装用户和公司标题名及字段名
        List<String[]> titles = assembleUserAndCompanyTitleAndFiled();
        // 组装用户信息和公司信息
        List<List> dataList = assembleUserAndCompanyInfo();
        // 用户信息和公司信息Excle导出
        HSSFWorkbook workbook = ExcelUtils.exportMoreSheet(wb, sheetNames, titles, dataList, styleMap);
        // 设置Excel名称
        String fileName = "用户信息明细和用品明细导出";
        // 将工作薄写入excel中
        ExcelUtils.export(response, workbook, fileName);
    }

    /**
     * 组装用户和公司标题名及字段名
     *
     * @return
     */
    private List<String[]> assembleUserAndCompanyTitleAndFiled() {
        List<String[]> titles = new ArrayList<>();
        // 用户信息标题和字段名
        String[] userTitles = new String[]{"用户名#userName", "手机号#phone",
                "省份#province", "城市#city", "工资#salary", "入职日期#hireDate"};
        // 公司信息标题和字段名
        String[] companys = new String[]{"用品名称#name", "价格#price", "是否需要归还#needReturn"};
        titles.add(userTitles);
        titles.add(companys);
        return titles;
    }

    /**
     * 组装用户信息和公司信息
     *
     * @return
     */
    private List<List> assembleUserAndCompanyInfo() {
        List<List> dataList = new ArrayList<>();
        // 获取用户全量信息
        List<User> tbUsers = userService.findAll();
        List<User> userInfoExcels = new ArrayList<>();
        // 获取公司全量信息
        List<Resource> resources = resourceMapper.selectAll();
        dataList.add(tbUsers);
        dataList.add(resources);
        return dataList;
    }

    /**
     * 用于深克隆行
     */
    private void copyRow(XWPFTable xwpfTable, XWPFTableRow sourceRow, int rowIndex) {
        XWPFTableRow targetRow = xwpfTable.insertNewTableRow(rowIndex);
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
//        获取源行的单元格
        List<XWPFTableCell> cells = sourceRow.getTableCells();
        if (CollectionUtils.isEmpty(cells)) {
            return;
        }
        XWPFTableCell targetCell = null;
        for (XWPFTableCell cell : cells) {
            targetCell = targetRow.addNewTableCell();
//            附上单元格的样式
//            单元格的属性
            targetCell.getCTTc().setTcPr(cell.getCTTc().getTcPr());
            targetCell.getParagraphs().get(0).getCTP().setPPr(cell.getParagraphs().get(0).getCTP().getPPr());
        }
    }

    /**
     * 向单元格中写入图片
     */
    private void setCellImage(XWPFTableCell cell, File imageFile) {

        XWPFRun run = cell.getParagraphs().get(0).createRun();
//        InputStream pictureData, int pictureType, String filename, int width, int height
        try (FileInputStream inputStream = new FileInputStream(imageFile)) {
            run.addPicture(inputStream, XWPFDocument.PICTURE_TYPE_JPEG, imageFile.getName(), Units.toEMU(100), Units.toEMU(50));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void userExport(List<User> users, HttpServletResponse response) {
        // 1.创建工作薄
        Workbook wb = new XSSFWorkbook();
        // 2.创建工作页
        Sheet sheet = wb.createSheet("用户信息导出");
        // 3.设置表头
        setTitle(sheet, wb);
        // 4. 写入数据
        wirteData(users, sheet, wb);
        // 5.写入流
        ExcelUtils.export(response, wb, "用户信息导出.xlsx");
    }

    private void wirteData(List<User> users, Sheet sheet, Workbook wb) {
        File rootFile = null;
        try {
            rootFile = new File(ResourceUtils.getURL("classpath:").getPath()); //获取项目的根目录
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int rowIndex = 0; rowIndex < users.size(); rowIndex++) {
            Row row = sheet.createRow(rowIndex + 1);
            User user = users.get(rowIndex);
            // 员工名
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(user.getUserName());
            sheet.setColumnWidth(0, ExcelUtils.getAutoColWidth(sheet, 0));
            // 手机号
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(user.getPhone());
            sheet.setColumnWidth(1, ExcelUtils.getAutoColWidth(sheet, 1));
            // 省份名
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(user.getProvince());
            sheet.setColumnWidth(2, ExcelUtils.getAutoColWidth(sheet, 2));
            // 城市名
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(user.getCity());
            sheet.setColumnWidth(3, ExcelUtils.getAutoColWidth(sheet, 3));
            // 工资
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(user.getSalary());
            sheet.setColumnWidth(4, ExcelUtils.getAutoColWidth(sheet, 4));
            // 入职日期
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD));
            sheet.setColumnWidth(5, ExcelUtils.getAutoColWidth(sheet, 5));
            // 部门id
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(user.getDeptId());
            sheet.setColumnWidth(6, ExcelUtils.getAutoColWidth(sheet, 6));
            // 出生日期
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(DateUtils.dateToString(user.getBirthday(), DateUtils.FORMAT_YYYY_MM_DD));
            sheet.setColumnWidth(7, ExcelUtils.getAutoColWidth(sheet, 7));
            // 一寸照片
            ExcelUtils.handlePhoto(wb, sheet, rootFile, user.getPhoto(), rowIndex + 1, 8);
            // 现在居住地址
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(user.getAddress());
            sheet.setColumnWidth(9, ExcelUtils.getAutoColWidth(sheet, 9));
        }
    }

    private void handlePhoto(Workbook wb, Sheet sheet, File rootFile, String photo, int rowIndex, int cellIndex) {
        try {
            //        照片的位置
//        开始处理照片
//        先创建一个字节输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        读取图片 放入了一个带有缓存区的图片类中
            BufferedImage bufferedImage = ImageIO.read(new File(rootFile, photo));
//       把图片写入到了字节输出流中
            String extName = photo.substring(photo.lastIndexOf(".") + 1).toUpperCase();
            ImageIO.write(bufferedImage, extName, byteArrayOutputStream);
//        Patriarch 控制图片的写入 和ClientAnchor 指定图片的位置
            Drawing patriarch = sheet.createDrawingPatriarch();
//        指定图片的位置         开始列3 开始行2   结束列4  结束行5
//        偏移的单位：是一个英式公制的单位  1厘米=360000
            ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, cellIndex, rowIndex, cellIndex + 1, rowIndex + 1);
//        开始把图片写入到sheet指定的位置
            int format = 0;
            switch (extName) {
                case "JPG": {
                    format = XSSFWorkbook.PICTURE_TYPE_JPEG;
                }
                case "JPEG": {
                    format = XSSFWorkbook.PICTURE_TYPE_JPEG;
                }
                case "PNG": {
                    format = XSSFWorkbook.PICTURE_TYPE_PNG;
                }
            }
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOutputStream.toByteArray(), format));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTitle(Sheet sheet, Workbook wb) {
        CellStyle cellStyle = ExcelUtils.titleStyle(wb);
        Row titleRow = sheet.createRow(0);
        // 员工名
        Cell cell0 = titleRow.createCell(0);
        cell0.setCellValue("员工名");
        cell0.setCellStyle(cellStyle);
        // 手机号
        Cell cell1 = titleRow.createCell(1);
        cell1.setCellValue("手机号");
        cell1.setCellStyle(cellStyle);
        // 省份名
        Cell cell2 = titleRow.createCell(2);
        cell2.setCellValue("省份名");
        cell2.setCellStyle(cellStyle);
        // 城市名
        Cell cell3 = titleRow.createCell(3);
        cell3.setCellValue("城市名");
        cell3.setCellStyle(cellStyle);
        // 工资
        Cell cell4 = titleRow.createCell(4);
        cell4.setCellValue("工资");
        cell4.setCellStyle(cellStyle);
        // 入职日期
        Cell cell5 = titleRow.createCell(5);
        cell5.setCellValue("入职日期");
        cell5.setCellStyle(cellStyle);
        // 部门id
        Cell cell6 = titleRow.createCell(6);
        cell6.setCellValue("部门id");
        cell6.setCellStyle(cellStyle);
        // 出生日期
        Cell cell7 = titleRow.createCell(7);
        cell7.setCellValue("出生日期");
        cell7.setCellStyle(cellStyle);
        // 一寸照片
        Cell cell8 = titleRow.createCell(8);
        cell8.setCellValue("一寸照片");
        cell8.setCellStyle(cellStyle);
        // 现在居住地址
        Cell cell9 = titleRow.createCell(9);
        cell9.setCellValue("现在居住地址");
        cell9.setCellStyle(cellStyle);
    }

    /**
     * 使用easyPOI导出
     *
     * @param response
     */
    public void easyPoiExport(HttpServletResponse response) {
        try {
            // 参数1: excel的标题  参数2: sheet也名称  参数3: excel文件格式
            ExportParams exportParams = new ExportParams("员工信息列表", "数据", ExcelType.XSSF);
            List<User> userList = userMapper.selectAll();
            // 参数1: Excel的参数  参数2: 映射的对象   参数3: 数据
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, userList);
            String fileName = "用户数据的导出.xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用easyPOI导入
     *
     * @param file
     */
    public void easyPoiImport(MultipartFile file) {
        try {
            // 导入参数
            ImportParams importParams = new ImportParams();
            // 是否保存文件
            importParams.setNeedSave(false);
            // 大标题占用多少行
            importParams.setTitleRows(1);
            // 小标题占用多少行
            importParams.setHeadRows(1);
            // 参数1: 文件流  参数2: 映射类加载器  参数3: 导入的参数对象
            List<User> userList = ExcelImportUtil.importExcel(file.getInputStream(), User.class, importParams);
            for (User user : userList) {
                // 我们接受数据的时候,自动生成了ID,需要清除掉
                user.setId(null);
                userMapper.insert(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用easyPOI模板导出
     *
     * @param response
     */
    public void easyPoiExportTimplate(HttpServletResponse response) {
        try {
            // 1.获取模板
            File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
            File templateFile = new File(rootFile, "/excel_template/userInfo3.xlsx");
            // 2.设置模板参数(参数1: 文件的路径,参数2: 是否遍历我们所有的sheet,true是,false不是,参数3: 可变长度的参数,可有可无)
            TemplateExportParams templateExportParams = new TemplateExportParams(templateFile.getPath(), true);
            // 3.读取数据
            User user = userMapper.selectByPrimaryKey(1);
            Map<String, Object> map = EntityUtils.entityToMap(user);
            // 处理图片
            ImageEntity imageEntity = new ImageEntity();
            // 设置url
            imageEntity.setUrl(user.getPhoto());
            // 设置图片大小
            // 图片需要占几列
            imageEntity.setColspan(2);
            // 图片需要占几行
            imageEntity.setRowspan(4);
            // 放入实体map中,key是单元格映射的那个字段
            map.put("photo", imageEntity);
            // 3.通过EasyPOI工具导出模板数据
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            // 4.写入流
            String fileName = "用户数据模板方式导出.xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用easyPOI导出CSV文件
     *
     * @param response
     */
    public void easyPoiExportCSV(HttpServletResponse response) {
        try {
            String fileName = "easyPoi导出CSV文件.xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            response.setContentType("test/csv");
            CsvExportParams csvExportParams = new CsvExportParams();
            // 场景: 文本里面是没法放照片的,想要排除照片,解决方案: 对对象中的照片字段不做解析,去掉注解,这样的话之前的导出图片就失效了
            // 排除的意思,把什么什么字段排除掉,不做解析,注意这里放的是:照片两个字而不是photo这个字段
            csvExportParams.setExclusions(new String[]{"一寸照片"});
            List<User> userList = userMapper.selectAll();
            CsvExportUtil.exportCsv(csvExportParams, User.class, userList, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 使用easyPOI导出CSV文件
     *
     * @param response
     */
    public void easyPoiExportWord(HttpServletResponse response) {
        try {
            // 1.获取模板
            File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
            File templateFile = new File(rootFile, "word_template/contract_template2.docx");
            // 2.准备数据
            User user = userService.findById(3L);
            // 3.模板文档结合数据
            Map<String, Object> params = new HashMap<>();
            params.put("userName", user.getUserName());
            params.put("hireDate", DateUtils.dateToString(user.getHireDate(), DateUtils.FORMAT_YYYY_MM_DD));
            params.put("address", user.getAddress());
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setUrl(rootFile.getPath() + user.getPhoto());
            imageEntity.setWidth(100);
            imageEntity.setHeight(100);
            params.put("photo", imageEntity);
            // 组装resource
            List<Map<String, Object>> resourceMapList = new ArrayList<>();
            Map<String, Object> map = null;
            for (Resource resource : user.getResourceList()) {
                map = new HashMap<>();
                map.put("name", resource.getName());
                map.put("needReturn", resource.getNeedReturn());
                map.put("price", resource.getPrice());
                // map.put("photo", resource.getPhoto());
                resourceMapList.add(map);
            }
            params.put("resourceList", resourceMapList);

            // 导出word
            XWPFDocument word = WordExportUtil.exportWord07(templateFile.getPath(), params);
            String filename = "员工(" + user.getUserName() + ")合同.docx";
            response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes(), "ISO8859-1"));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            word.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
