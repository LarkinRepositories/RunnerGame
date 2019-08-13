package Lesson_7.Server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement statement;


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zChat", "postgres", "postgres");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserIDByLoginAndPass(String login, String password) throws SQLException {
        String query = String.format("SELECT id FROM users WHERE login='%s' and password = '%s'", login, password);
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) return rs.getInt(1);
        return 0;
    }

    public static String getNickNameByLoginAndPass(String login, String password) throws SQLException {
        String query = String.format("SELECT nickname FROM users WHERE login='%s' and password = '%s'", login, password);
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) return rs.getString(1);
        return null;
    }

    public static void blacklist(int userID, String nickname) throws SQLException {
        String query = String.format("INSERT into blacklist VALUES(%s, '%s')", userID, nickname);
        statement.executeUpdate(query);
    }
}
