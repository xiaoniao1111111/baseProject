package com.mybatis;


import com.alibaba.fastjson.JSONObject;
import com.noah.domain.TbUser;
import com.spring.mybatis.data.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

/**
 *
 * @Author WangXinWei
 * @Date 2022/3/5 11:22
 * @Version 1.0y
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        // 通过JDBC的方式获取数据结果
        //jdbcTest();
        // 通过Mybatis获取数据结果集
       // mybatisTest();
        String reource = "mybatis-config.xml";
        InputStream resource = Resources.getResourceAsStream(reource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = factory.openSession(true);
        List<UserInfo> info = sqlSession.selectList("userMapper.getOderIno", 20140921001L);
        info.forEach(item->{
            System.out.println(JSONObject.toJSONString(item));
            String orderNumber = item.getOrderNumber();
            System.out.println(orderNumber);
        });
    }

    private static void mybatisTest() throws IOException {
        String source = "mybatis-config.xml";
        InputStream resource = Resources.getResourceAsStream(source);
        // 获取工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        // 获取会话
        SqlSession sqlSession = factory.openSession();
        // 执行器
        TbUser user = (TbUser) sqlSession.selectOne("userMapper.getUserInfo", 1L);
        System.out.println(JSONObject.toJSONString(user));
    }

    private static void jdbcTest() throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/sqltest";
        String user = "root";
        String password = "w6127176w";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 3.  获取statement
        String sql = "select * from tb_user where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        // 4. 设置参数
        // 设置参数
        ps.setLong(1, 1l);
        // 5. 执行查询，获取结果集
        ResultSet resultSet = ps.executeQuery();
        // 6. 处理结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("age"));
        }
        // 7. 关闭连接
        resultSet.close();
        ps.close();
        connection.close();
    }
}
