package club.bestchu.servlet;

import club.bestchu.entity.Employee;
import club.bestchu.service.EmployeeService;
import club.bestchu.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by bestchu on 2017/7/17.
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private String uri;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Employee> list = employeeService.getAll();
            request.setAttribute("listEmp", list);
            uri = "/list.jsp";
        }catch(Exception e){
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
