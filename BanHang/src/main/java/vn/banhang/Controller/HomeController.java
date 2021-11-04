package vn.banhang.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.banhang.DAO.CategoryDAO;
import vn.banhang.DAO.ProductDAO;
import vn.banhang.Model.CategoryModel;
import vn.banhang.Model.ProductModel;

@WebServlet(urlPatterns = {"/home", "/"})
public class HomeController  extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    ProductDAO pd =new ProductDAO();
    CategoryDAO cd= new CategoryDAO();
    List<CategoryModel> listCate = cd.CategoryAll();
    List<ProductModel> listop4 = pd.get4product();
    List<ProductModel> list1 = pd.list1product();
    List<ProductModel> list4amount = pd.list4amount();
    req.setAttribute("listcategory", listCate);
    req.setAttribute("list1product", list1);
    req.setAttribute("list4product", listop4);
    req.setAttribute("list4amount", list4amount);
    RequestDispatcher rq= req.getRequestDispatcher("/views/home.jsp");
    rq.forward(req,resp);

    
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
