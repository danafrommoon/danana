package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import beans.Product;
import beans.User;

//This controller servlet controls all sessions and cart

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<Product> list = new ArrayList<>();
    static ArrayList<String> cartlist = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    HttpSession session;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page == null || page.equals("main")) {


            session = request.getSession();
            session.setAttribute("cartlist", cartlist);
            session.setAttribute("list", list);

            request.getRequestDispatcher("main.jsp").forward(request, response);
        }else {
            doPost(request, response);
        }
    }
//referencing files to names
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.equals("login")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if(page.equals("register")) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

        if(page.equals("sessionmanagement")) {
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//registering user to start session
            if(password != null) {

                User user = new User();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setPassword(password);


                request.setAttribute("firstname", firstname);
                request.setAttribute("msg", "Account created successfully, Please Login!");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

        }

        if(page.equals("login-form")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            boolean status = false;
            if(status) {
                session = request.getSession();
                session.setAttribute("session", session);
                session.setAttribute("username", username);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }else {
                request.setAttribute("msg", "Invalid Crediantials");
                request.setAttribute("username", username);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
//if user click logout, then products in cart deleted
        if(page.equals("logout")) {
            session = request.getSession();
            session.invalidate();

            session = request.getSession();
            cartlist.clear();
            session.setAttribute("cartlist", cartlist);
            session.setAttribute("list", list);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
// referencing pages t their name
        if(page.equals("mobiles") || page.equals("laptops") || page.equals("clothing") || page.equals("all-products")) {

            request.setAttribute("list", list);

            if(page.equals("mobiles"))
                request.getRequestDispatcher("mobiles.jsp").forward(request, response);
            if(page.equals("laptops"))
                request.getRequestDispatcher("laptops.jsp").forward(request, response);
            if(page.equals("clothing"))
                request.getRequestDispatcher("clothing.jsp").forward(request, response);
            if(page.equals("all-products"))
                request.getRequestDispatcher("all-products.jsp").forward(request, response);
        }



        if(page.equals("cart")) {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }

        if(page.equals("price-sort")) {
            String price = request.getParameter("sort");
            String action = request.getParameter("action");
            Product p = new Product();
            if(price.equals("low-to-high"))
                list = p.lowtohigh(list);
            else
                list = p.hightolow(list);

            session.setAttribute("list", list);

            if(action.equals("main"))
                request.getRequestDispatcher("main.jsp").forward(request, response);
            if(action.equals("all-products"))
                request.getRequestDispatcher("all-products.jsp").forward(request, response);
            if(action.equals("mobiles"))
                request.getRequestDispatcher("mobiles.jsp").forward(request, response);
            if(action.equals("laptops"))
                request.getRequestDispatcher("laptops.jsp").forward(request, response);
            if(action.equals("clothing"))
                request.getRequestDispatcher("clothing.jsp").forward(request, response);
        }
    }

}