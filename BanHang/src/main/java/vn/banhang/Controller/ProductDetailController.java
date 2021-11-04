package vn.banhang.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.banhang.DAO.ProductDAO;
import vn.banhang.Model.ProductModel;

@WebServlet(urlPatterns = {"/productdetail",})
public class ProductDetailController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    req.setCharacterEncoding("UTF-8");
    String pid = req.getParameter("pid");
    ProductDAO pd =new ProductDAO();
    ProductModel pro = pd.getAllproductbyPID(pid);
    req.setAttribute("getproductbupid", pro);
    RequestDispatcher rq= req.getRequestDispatcher("/views/productdetail.jsp");
    rq.forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
