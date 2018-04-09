package Controller.Servlets;

import Controller.ConnectionMySql;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class GetByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    int ID = Integer.parseInt(request.getParameter("userId"));
    ConnectionMySql con = new ConnectionMySql();
        try {
            User user = (User) con.findById(ID);//поиск в бд по йд
           String nameUser = user.getName();
            String sureNameUser = user.getSureName();
            request.setAttribute("name",nameUser);
            request.setAttribute("sureName",sureNameUser);
            request.getRequestDispatcher("UserByID.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
