package erp_jsp_exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
   public static Connection getConnection() {
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      try{
         String url = "jdbc:mysql://localhost:3306/erp_jsp_exam?useSSL=false";
         String id = "ERP_JSP_EXAM";
         String passwd = "rootroot";
         con = DriverManager.getConnection(url, id, passwd);
               
      }catch (SQLException e) {
         e.printStackTrace();
      }
      
      return con;
      
   }
}