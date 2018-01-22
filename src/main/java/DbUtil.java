import org.omg.PortableInterceptor.INACTIVE;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/helix";
    private static final String USER = "postgres";
    private static final String PASSWORD = "post";
    private static DbUtil INSTANCE;      //singleton design pattern

    private DbUtil() {

    }

    public Connection getConnection() {
        //1.
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DbUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DbUtil();
        }

        return INSTANCE;
    }
}
