package com.study;

import com.study.pojo.Item;
import com.study.repository.EsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名称:EsTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-18
 * @版本:V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private EsRepository repository;

    /**
     * 创建索引库
     */
    @Test
    public void createIndex() {
        template.createIndex(Item.class);
    }

    /**
     * 创建mapping
     */
    @Test
    public void createMapping() {
        template.putMapping(Item.class);
    }

    /**
     * 添加数据
     */
    @Test
    public void createDocuments() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        repository.save(item);
    }

    /**
     * 批量添加数据 
     */
    @Test
    public void batchCreateDocuments() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        repository.saveAll(list);
    }
}
