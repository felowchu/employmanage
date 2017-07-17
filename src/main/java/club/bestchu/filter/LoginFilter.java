package club.bestchu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bestchu on 2017/7/17.
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/")+1, uri.length());
        if("login".equals(path) || "login.jsp".equals(path)){
            chain.doFilter(request, response);
        }else{
            HttpSession session = request.getSession(false);
            if(session != null){
                Object obj = session.getAttribute("loginInfo");
                if(obj != null){
                    chain.doFilter(request, response);
                }else{
                    uri = "/login.jsp";
                }
            }else{
                uri = "/login.jsp";
            }
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
