package patternSingleton;
import java.sql.*;

public class Database {
    private static final Database instance;
    private Connection connection;
    private String url = "url";
    private String username = "user";
    private String password = "psw";

    static{
        instance = new Database();
    }
    private Database() {
        System.out.println("Instanciation du Singleton");
    }

    public static Database getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet query(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}