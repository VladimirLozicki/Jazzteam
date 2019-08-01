package org.jazzteam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class PrepareStatementDemo {
    private static final Logger logger = Logger.getGlobal();
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "1111";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name;
        logger.info("Registering JDBC driver...");
        Class.forName("org.postgresql.Driver");
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Statement statement;
        String SQL = null;
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                name = resultSet.getString("name");
                logger.info("name : " + name);
            }

            SQL = "Update users SET name=? WHERE password=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, "vova");
            preparedStatement.setInt(2, 12345);
            preparedStatement.executeUpdate();
            while (resultSet.next()) {
                name = resultSet.getString("name");
                logger.info("name : " + name);
            }

            SQL = "SELECT  * FROM users WHERE password=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, 12345678);
            resultSet = preparedStatement.executeQuery();
            int pass;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                pass = resultSet.getInt("password");
                logger.info("name : " + name);
                logger.info("password : " + pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

