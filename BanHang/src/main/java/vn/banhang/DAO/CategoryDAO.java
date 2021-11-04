package vn.banhang.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.banhang.DBconnect.DBconnect;
import vn.banhang.Model.CategoryModel;

public class CategoryDAO {
  Connection conn = null;
  PreparedStatement ps= null;
  ResultSet rs = null;
  public List<CategoryModel> CategoryAll() {
    List<CategoryModel> list =new ArrayList<CategoryModel>();
    String sql = "select * from Category";
    try {
      conn = new DBconnect().getConnection();
      ps= conn.prepareStatement(sql);
      rs= ps.executeQuery();
      while (rs.next())
      {
        list.add(new CategoryModel(rs.getInt(1),
            rs.getString(2),
            rs.getString(3)));
      }
    }catch (Exception e){}
    return list;

  }

}
