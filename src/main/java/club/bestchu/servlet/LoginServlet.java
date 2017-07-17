package club.bestchu.servlet;

import club.bestchu.entity.Admin;
import club.bestchu.service.AdminService;
import club.bestchu.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bestchu on 2017/7/17.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    private String uri;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        try{
            Admin loginInfo = adminService.findByNameAndPassword(admin);
            if(loginInfo == null)
                uri = "/login.jsp";
            else{
                request.getSession().setAttribute("loginInfo", loginInfo);
                uri = "/list";
            }
        }catch(Exception e){
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
