package Tests.API_DB_tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_ConnectionManager {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://gym2gym-db.cao1qzgvedxg." +
                "us-west-2.rds.amazonaws.com:5432/" +
                "initial_gym2gym_db", "postgres", "Newlife12*")) {
            if (conn != null) {
                System.out.println("Connected to the database! ");
            } else {
                System.out.println("Failed to make connection ( ");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: &s\n&s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

