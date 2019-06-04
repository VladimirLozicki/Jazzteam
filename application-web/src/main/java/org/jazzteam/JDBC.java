package org.jazzteam;

import org.jazzteam.singleton.Equals;

import java.sql.*;
import java.util.logging.Logger;

public class JDBC {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1111";
        String actual = "";
        String expected = "54321";
        Equals equals = new Equals();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username='ivan'");

            while (resultSet.next()) {
                  actual = resultSet.getString(1);
                  logger.info(String.valueOf(actual.equals(expected)));
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

