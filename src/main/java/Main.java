import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        //1. Driver regisztráció
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            // 2. kapcsolat létrehozás
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/helix","postgres","post");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
