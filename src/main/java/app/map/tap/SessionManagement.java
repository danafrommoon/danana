package app.map.tap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
// This servlet class for register
@WebServlet(name = "SessionManagement", urlPatterns = "/sessionmanagement")
public class SessionManagement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        PrintWriter out = response.getWriter();

        HttpSession newSession = request.getSession(true);
        newSession.setMaxInactiveInterval(60);

        String welcome;

        Integer counter = 0;
        try{
            if(newSession.isNew()){
                //There user first time visited to site
                welcome = firstName + ",Welcome to the our online-shop! It is your first time you are visiting this website.";
            }
            else {
                welcome = "Welcome back, " + firstName + "!";

                Integer count = (Integer)newSession.getAttribute("counter");

                if(count!=null){
                    counter = new Integer(count.intValue()+1);
                }
            }
            //There shown information user's session
            newSession.setAttribute("counter",counter);
            out.println("<html><head><title>Session Management </title></head><body>");
            out.println("<h3>"+welcome + "</h3><br>");
            out.println("<b> Session Id: </b>"+ newSession.getId() + "<br>");
            out.println("<b> Creation time of the Session: </b>" + new Date(newSession.getCreationTime())+"<br>");
            out.println("<b> Last access time: </b>" + new Date (newSession.getLastAccessedTime())+"<br>");
            out.println("<b> Maximum inactive interval time: </b>" + newSession.getMaxInactiveInterval() + "<br>");

            out.println("You have visited this page " + (++counter));
            // There shown information how many times visited to site
            if(
                    counter == 1){
                out.println(" time ");
            }else{
            out.println(" times ");
            }
            out.println("<a href='main.jsp'>Go to the shop</a>");
            out.println("</body></html>");
        }
        finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
