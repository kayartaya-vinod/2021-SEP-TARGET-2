package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class GetAllCustomers {
    public static void main(String[] args) {
        String sql = "select * from customers";

        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql); // visit to db server
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                log.debug("id={}, name={}, email={}, city={}", id, name, email, city);
            }

        } catch (Exception e) {
            log.error("Error while accessing customer data", e);
        }
    }
}
