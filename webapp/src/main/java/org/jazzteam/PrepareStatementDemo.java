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
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String SQL = "SELECT * FROM users_1";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                name = resultSet.getString("username");
                logger.info("name : " + name);
            }

            SQL = "Update users_1 SET username='yuewiwfw' WHERE password=12345";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.executeUpdate();
            while (resultSet.next()) {
                name = resultSet.getString("username");
                logger.info("name : " + name);
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
