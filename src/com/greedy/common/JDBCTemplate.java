package com.greedy.common;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

   public static Connection getConnection() {
      
      Connection con = null;
      
      Properties prop = new Properties();
      
      try {
         prop.load(new FileReader("config/connection-info.properties"));
         
         String driver = prop.getProperty("driver");
         String url = prop.getProperty("url");
         
         Class.forName(driver);
         
         con = DriverManager.getConnection(url, prop);
         
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return con;
   }
   
   public static void close(Connection con) {
      try {
         if(con != null && !con.isClosed()) {
            con.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Statement stmt) {
      
      try {
         if(stmt != null && !stmt.isClosed()) {
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void close(ResultSet rset) {
      
      try {
         if(rset != null && rset.isClosed()) {
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}