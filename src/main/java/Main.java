import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //1. Driver regisztráció
      //  Connection connection = null;
        Connection connection;
        Statement statement = null;
        Statement statement1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
         //   Class.forName("org.postgresql.Driver");
            // 2. kapcsolat létrehozás
           // connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/helix", "postgres", "post");
                connection = DbUtil.getInstance().getConnection();
            //3. Creating statement
            statement = connection.createStatement();
            statement1 = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM actor;");
            rs1 = statement1.executeQuery("SELECT * FROM country;");

            while (rs.next()) {
                /*
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdate = rs.getString("last_update");
*/
                Actor actor = new Actor(rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("last_update")
                );

             //   System.out.println(actor.toString());
            }

            while (rs1.next()) {
                Country country = new Country();
                country.setCountryID(rs1.getInt("country_id"));
                country.setCountry(rs1.getString("country"));
                country.setLastUpdate(rs1.getString("last_update"));

                System.out.println(country.toString());
            }

        }/* catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/ catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement1 != null) {
                    try {
                        statement1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rs1 != null) {
                    try {
                        rs1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

