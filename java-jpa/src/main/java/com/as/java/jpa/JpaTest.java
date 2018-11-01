package com.as.java.jpa;

import java.sql.*;

/**
 * desc:
 * author: as
 * date: 2018/11/1 10:50
 */
public class JpaTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "renewal_dev", "dev#123");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from testuser");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            int row = rs.getRow();
            System.out.println(row);
            System.out.println(rs.getString("usercode"));
            System.out.println(rs.getString("usercname"));
        }
        // 连接数据库
    }
}
