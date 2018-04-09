package Controller.Servlets;

import Controller.ConnectionMySql;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RichestUser extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConnectionMySql con = new ConnectionMySql();

        try {
            User user = (User) con.richedUser();
            if(user!=null) {
                String nameUser = user.getName();
                String sureNameUser = user.getSureName();
                request.setAttribute("name", nameUser);
                request.setAttribute("sureName", sureNameUser);
                request.getRequestDispatcher("/views/RichestUser.jsp").forward(request, response);
            }
            else{
                String nameUser = "No one is rich!";

                request.setAttribute("name", nameUser);

                request.getRequestDispatcher("/views/RichestUser.jsp").forward(request, response);
            }

            } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    }

