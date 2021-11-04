package vn.banhang.DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
  private final String userID ="sa";
  private final String password= "123";
  private final String instance="";
  public Connection getConnection () throws Exception{
    String url = "jdbc:sqlserver://DESKTOP-EEAT8JT\\SQLEXPRESS:1433;database=BanHang";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    return DriverManager.getConnection(url, userID, password);
  }
public static void main(String[] args) {
  try {
    System.out.println(new DBconnect().getConnection());
  }catch (Exception e){}
}


}
