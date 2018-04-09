package Controller.Servlets;

import Controller.ConnectionMySql;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    int ID = Integer.parseInt(request.getParameter("userId"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConnectionMySql con = new ConnectionMySql();

        try {
            User user = (User) con.findById(ID);
            if(user!=null) {
                String nameUser = user.getName();
                String sureNameUser = user.getSureName();
                request.setAttribute("name", nameUser);
                request.setAttribute("sureName", sureNameUser);
                request.getRequestDispatcher("/views/UserByID.jsp").forward(request, response);
            }
            else{
                String nameUser = "Name User Not found! ";
                String sureNameUser = " SureName User Not found!";
                request.setAttribute("name", nameUser);
                request.setAttribute("sureName", sureNameUser);
                request.getRequestDispatcher("/views/UserByID.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
