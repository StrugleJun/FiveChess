package com.seem.test;


import com.seem.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

        Connection connection = ConnectionUtils.getConnection();

        if (connection != null){
            System.out.printf("连接已经关闭");
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        Connection conn = ConnectionUtils.getConnection();

        if (conn != null){
            System.out.printf("连接已经关闭");
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

}
