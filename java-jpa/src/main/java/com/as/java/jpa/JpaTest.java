package com.as.java.jpa;

import java.sql.*;

/**
 * desc:
 * author: as
 * date: 2018/11/1 10:50
 */
public class JpaTest {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//139.9.206.60:1521/ORCLPDB1.localdomain", "CLAIMCORE_UAT3", "Tt123456");
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("update T_AUTH_USER set C_CARD_CDE='test003' where c_account='chen'");
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
        Thread.sleep(5000L);
        connection.commit();
        connection.close();
//        ResultSet rs = preparedStatement.executeQuery();
//        while(rs.next()) {
//            int row = rs.getRow();
//            System.out.println(row);
//            System.out.println(rs.getString("C_ACCOUNT"));
//        }
        // 连接数据库
    }
}
