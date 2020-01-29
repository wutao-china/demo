package com.magicbank.mybatis;

import com.alibaba.fastjson.JSON;
import com.oracle.javafx.jmx.json.JSONFactory;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: jdbc测试
 * @author: wutao
 * @create: 2020/01/29 18:54
 **/
public class JDBCTest {
    @Test
    public void testJdbcSelect(){
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/b2bmall?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "root");

            //3、查询
            preparedStatement = connection.prepareStatement("select id, name, mobile from t_user");

            //4、数据转化实体类
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setMobile(resultSet.getString("mobile"));
                userList.add(user);
            }

            System.out.println("JSON.toJSONString(userList) = " + JSON.toJSONString(userList));

            //5、关闭资源
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testJdbcUpdate(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/b2bmall?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "root");

            //3、事务手动提交
            connection.setAutoCommit(false);

            //4、更新/新增
            preparedStatement = connection.prepareStatement("update t_user set update_time = now() where id = ?");
            preparedStatement.setInt(1, 1);
            int r = preparedStatement.executeUpdate();

            System.out.println("r = " + r);

            //5.提交事务
            connection.commit();

            //6、关闭资源（顺序）
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
