package Controller;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionMySql {
    private static final String url = "jdbc:mysql://localhost:3306/databasedv";
    private static final String user = "root";
    private static final String password = "root";

    public int accountSum() throws SQLException {

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stat = con.createStatement();

        String guery = "select sum(account) as `total_money` from `account` ";
        ResultSet rs = stat.executeQuery(guery);
        try {
            while (rs.next()) {
                int money = rs.getInt("total_money");
                System.out.print("Сумма " + money);
                return money;
            }
        } finally {
            try {
                rs.close();
                con.close();
                stat.close();
            } catch (Throwable notFound) { }

        }
        return 0;
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
        } finally {
            try {
                rs.close();
                con.close();
                stat.close();
            } catch (Throwable notFound) { }
        }
    return null;}

    public Object richedUser() throws SQLException {
        int maxMoney = 0;
        int userIdReach = 0;

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stat = con.createStatement();

        String guery = " SELECT MAX(account) as account from databasedv.account";
        ResultSet rs = stat.executeQuery(guery);
        try {
            while (rs.next()) {
                maxMoney = rs.getInt("account");
                System.out.print("Nashel 1 " + maxMoney);
            }
            String max = Integer.toString(maxMoney);
            String gueryTwo = " select userId from account where account =" + " '" + max + "' ";
            rs = stat.executeQuery(gueryTwo);
            try {
                while (rs.next()) {
                    userIdReach = rs.getInt("userId");
                    System.out.print("Nashel 2" + userIdReach);
                }
                String reach = Integer.toString(userIdReach);
                String gueryThree = " select name,sureName from user where userId =" + " '" + reach + "' ";
                 rs = stat.executeQuery(gueryThree);
                try {
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String sureName = rs.getString("sureName");
                        User find = new User(name, sureName);
                        System.out.print("Most rich " + name + " " + sureName);

                        return find;
                    }
                } finally {

                }
                try {
                } catch (Throwable notFound) {
                }

            } finally {

                try {
                } catch (Throwable notFound) {
                }
            }
        } finally {

        }
        try {

            rs.close();
            con.close();
            stat.close();

        } catch (Throwable notFound) {
            }

        return null;}

        public List getListUser() throws SQLException {

        List <User> users = new ArrayList<User>();

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stat = con.createStatement();

            String guery = "select name,sureName from user";
            ResultSet rs = stat.executeQuery(guery);

            try {
                while (rs.next() == true) {
                    String name = rs.getString("name");
                    String sureName = rs.getString("sureName");
                    User nextUser = new User(name, sureName);
                    users.add(nextUser);
                }
            }finally {}
            try{rs.close();
                con.close();
                stat.close();
            }
            catch (Throwable notFound) {
            }
            return users;}

        }
