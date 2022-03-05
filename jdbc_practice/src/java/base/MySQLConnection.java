/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mdlaptop
 */
public class MySQLConnection {

    public static Connection getConnection() {
        String strUrl = "jdbc:mysql://localhost:3306/campus?"
                + "user=root"
                + "&password=Hello@2020"
                + "&autoReconnect=true"
                + "&useSSL=false"
                + "&characterEncoding=utf8"
                + "&useUnicode=true";
        Connection conn = null;
        try {
            if (conn == null || conn.isClosed()) {
                //Class.forName("com.mysql.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(strUrl.trim());
                getDatabaseName(conn, strUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static String getDatabaseName(Connection conn, String url) {
        String dbname = "";
        try {
            if (conn != null) {
                String strUrl = conn.getMetaData().getURL();

                int lastSplash = strUrl.lastIndexOf("/");
                int firstQues = strUrl.length();
                if (strUrl.contains("?")) {
                    firstQues = strUrl.indexOf("?");
                }
                dbname = strUrl.substring(lastSplash + 1, firstQues);

            } else {
                System.out.println("conn null: " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbname;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
