package vn.banhang.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import vn.banhang.DBconnect.DBconnect;
import vn.banhang.Model.ProductModel;

public class ProductDAO {

  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;

  public List<ProductModel> get4product() {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = "SELECT TOP 4 * FROM dbo.Product ORDER BY ProductID DESC";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return list;
  }

  public List<ProductModel> list1product() {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = " select top 1 * from Product order by Amount desc";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return list;


  }

  public List<ProductModel> list4amount() {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = " select top 4 * from Product order by Amount desc";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return list;


  }

  public List<ProductModel> getAllproduct() {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = "SELECT * FROM dbo.Product ORDER BY ProductID DESC";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return list;
  }
  public List<ProductModel> getLastproduct() {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = "SELECT Top 1 * FROM dbo.Product ORDER BY ProductID DESC";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return list;
  }
  public List<ProductModel> getAllproductbyCID( String cid) {
    List<ProductModel> list = new ArrayList<ProductModel>();
    String sql = "SELECT * FROM dbo.Product where CategoryID= ?";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      ps.setString(1,cid);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8)));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return list;
  }
  public ProductModel getAllproductbyPID( String pid) {
    String sql = "SELECT * FROM dbo.Product where ProductID= ?";
    try {
      conn = new DBconnect().getConnection();
      ps = conn.prepareStatement(sql);
      ps.setString(1,pid);
      rs = ps.executeQuery();
      while (rs.next()) {
        return new ProductModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getInt(7),
            rs.getInt(8));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
}
