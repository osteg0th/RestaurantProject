package servlets;

import controllers.UserCommands.GetLoginCommand;
import controllers.UserController;
import entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AuthController")
//@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(login);
        user.setPassword(password);
        UserController ur = new UserController(new GetLoginCommand(user));
        ur.getLogin();
        request.getSession().setAttribute("user", user);
        if (login.equals(user.getEmail()) && password.equals(user.getPassword())) {
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMsg", "Login or password incorrect");
            request.getRequestDispatcher("/registration/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request, response);
    }
}
