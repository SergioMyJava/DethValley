package Controller.Servlets;

import Controller.ConnectionMySql;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Sum extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConnectionMySql con = new ConnectionMySql();

        try {
             int sum = con.accountSum();
System.out.print("Owere SUM"+sum);
                 request.setAttribute("sumAccount", sum);
                 request.getRequestDispatcher("/views/Sum.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }



    }
