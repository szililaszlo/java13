import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            connection = DbUtil.getInstance().getConnection();

            statement = connection.prepareStatement(SqlConstants.SELECT_LAST_N_ACTOR);
            statement.setInt(1, 5);
            rs = statement.executeQuery();

            while (rs.next()) {

                Actor actor = new Actor(rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("last_update")
                );
              //  System.out.println(actor.toString());
            }

            statement1=connection.prepareStatement(SqlConstants.SELECT_JOIn);
            statement1.setInt(1,0);
            rs1 = statement1.executeQuery();

            while (rs1.next()) {

                FilmActor filmActor = new FilmActor();
                        filmActor.setFirstName(rs1.getString("first_name"));
                        filmActor.setLastName(rs1.getString("last_name"));
                        filmActor.setTitle(rs1.getString("title"));

                System.out.println(filmActor.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

