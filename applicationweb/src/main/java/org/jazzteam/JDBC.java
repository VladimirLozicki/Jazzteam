package org.jazzteam;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/postgres.user";
        String username="postgres";
        String password="1111";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection(url, username, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT  * FROM  table_user");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

