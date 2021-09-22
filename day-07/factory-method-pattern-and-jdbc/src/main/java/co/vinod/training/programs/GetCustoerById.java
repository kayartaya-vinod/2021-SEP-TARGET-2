package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
public class GetCustoerById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter customer id to search: ");
        String sql = "select * from customers where id = ?";

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String city = rs.getString("city");
                    log.debug("id={}, name={}, email={}, city={}", id, name, email, city);
                } else {
                    log.warn("No data found for customer id {}", id);
                }
            }
        } catch (Exception e) {
            log.error("Error while accessing customer data", e);
        }


    }
}
