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
@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    String cid = req.getParameter("cid");
    ProductDAO pd =new ProductDAO();
    CategoryDAO cd= new CategoryDAO();
    List<ProductModel> listPCbyCID= pd.getAllproductbyCID(cid);
    List<ProductModel> listallproduct = pd.getAllproduct();
    List<CategoryModel> listCate = cd.CategoryAll();
    List<ProductModel> listop4 = pd.get4product();
    List<ProductModel> list1 = pd.list1product();
    List<ProductModel> list4amount = pd.list4amount();
    List<ProductModel> lastproduct = pd.getLastproduct();
    if ("0".equals(cid)){
      req.setAttribute("listPCbyCID", listallproduct);
    }else {
      req.setAttribute("listPCbyCID", listPCbyCID);
    }
    req.setAttribute("lastproduct", lastproduct);
    req.setAttribute("listallproduct", listallproduct);
    req.setAttribute("listcategory", listCate);
    req.setAttribute("list1product", list1);
    req.setAttribute("list4product", listop4);
    req.setAttribute("list4amount", list4amount);
    req.setAttribute("tagactive", cid);
    RequestDispatcher rq= req.getRequestDispatcher("/views/product.jsp");
    rq.forward(req,resp);


  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

}
