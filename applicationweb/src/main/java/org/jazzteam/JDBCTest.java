package org.jazzteam;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JDBCTest extends JDBC{
    @Test
    public void testMain() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1111";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username='ivan'");
            String actual = "";
            String expected = "54321";
            while (resultSet.next()) {
                actual = resultSet.getString(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
            assertEquals(actual, expected);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}