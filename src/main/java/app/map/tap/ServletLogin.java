package app.map.tap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//This servlet created for login
@WebServlet(name = "ServletLogin", urlPatterns = "/servletlogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//there we using cookie with username
        String n = request.getParameter("userName");

        Cookie ck = new Cookie("uname",n);
        response.addCookie(ck);
// after clicking submit in login page, user redirected to main page of shop
       response.sendRedirect("main.jsp");

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
