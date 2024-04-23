package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Wang Xin Wei
 * @version 1.0
 * @date : 2022-06-07 16:09
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // 需求：更改所有人的密码为 abcdef
        // 1 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2 创建连接
        String url = "jdbc:mysql://localhost:3306/day04_db";
        String user = "root";
        String password = "123";
        Connection conn = DriverManager.getConnection(url, user, password);
        // 3 获得发送sql的对象
        Statement stmt = conn.createStatement();
        // 4 执行sql 获得结果
        String sql = "update user set password='abcdef'";
        int sum = stmt.executeUpdate(sql);
        // 5 处理结果
        System.out.println(sum);
        // 6 关闭资源
        stmt.close();
        conn.close();
    }
}
