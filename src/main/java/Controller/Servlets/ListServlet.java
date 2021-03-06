package Controller.Servlets;

import Controller.ConnectionMySql;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConnectionMySql con = new ConnectionMySql();

        try {
            List<User> users = con.getListUser();
            if(users!=null) {
                request.setAttribute("users", users);
                request.getRequestDispatcher("/views/ListUser.jsp").forward(request, response);
            }
            else{
                String nameUser = "No users in the database!";

                request.setAttribute("name", nameUser);

                request.getRequestDispatcher("/views/UserByID.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
