package Controller;

import Model.User;

import java.sql.*;

public class ConnectionMySql {
    private static final String url = "jdbc:mysql://localhost:3306/databasedv";
    private static final String user = "root";
    private static final String password = "root";

    public void accountSum() throws SQLException {

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stat = con.createStatement();
        String guery = "select sum(account) as `total_money` from `account` ";
        ResultSet rs = stat.executeQuery(guery);
        try {
            while (rs.next()) {
                int money = rs.getInt("total_money");
                System.out.print("Сумма " + money);
            }
            if (rs.next() == Boolean.parseBoolean(null)) {
                System.out.print(" Object not exist!");
            }

        } finally {
            try {
                rs.close();
                con.close();
                stat.close();
            } catch (Throwable notFound) { }
        }
    }



    public Object findById(int ID) throws SQLException{


        Connection con = DriverManager.getConnection(url, user, password);

        Statement stat = con.createStatement();

        String guery = "SELECT name,sureName FROM databasedv.user WHERE userId =  " + " '" + ID + "' ";
        ResultSet rs = stat.executeQuery(guery);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String sureName = rs.getString("sureName");
                System.out.print("Name " + name + " SureName " + sureName);
                User find = new User(ID,name,sureName);
                return find;
            }
            if (rs.next() == Boolean.parseBoolean(null)) {
                System.out.print("Object not exist!");
            }

        } finally {
            try {
                rs.close();
                con.close();
                stat.close();
            } catch (Throwable notFound) { }
        }
    return null;}

}
