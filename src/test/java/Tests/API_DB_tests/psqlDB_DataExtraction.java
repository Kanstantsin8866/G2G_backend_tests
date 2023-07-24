package Tests.API_DB_tests;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class psqlDB_DataExtraction {
@Test
    public void psql_id_firstN_lastN_email_test() throws SQLException {

        List<USERS> user = new ArrayList<>();

        String SQL_SELECT = "SELECT \"userId\",\"firstName\",\"lastName\",\"email\" FROM users ORDER BY CAST(\"userId\" AS INT)";
        //

        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://gym2gym-db.cao1qzgvedxg." +
                "us-west-2.rds.amazonaws.com:5432/" +
                "initial_gym2gym_db","postgres","Newlife12*");

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Connection established !");

            while (resultSet.next()) {


                long id = resultSet.getLong("userId");
                String firstname = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                String emailName = resultSet.getString("email");


                USERS obj = new USERS();
                obj.setId(id);
                obj.setFirstname(firstname);
                obj.setLastname(lastname);
                obj.setEmail(emailName);
                user.add(obj);
            }
            user.forEach(System.out::println);
            //System.out.println(user);

        }catch (SQLException e) {
            System.err.format("SQL State:%s\n%s",e.getSQLState(), e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }



    }

}
