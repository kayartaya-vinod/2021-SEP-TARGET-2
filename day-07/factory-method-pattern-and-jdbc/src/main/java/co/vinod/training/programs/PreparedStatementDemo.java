package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Slf4j
public class PreparedStatementDemo {
    public static void main(String[] args) {
        int id;
        String name;
        String email;
        String city;
        String choice;
        String sql = "insert into customers values (?, ?, ?, ?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // sql insert command without values goes to the server
        ) {
            do {
                try {
                    id = KeyboardUtil.getInt("Enter id      : ");
                    name = KeyboardUtil.getString("Enter name    : "); // Vijay', 'v@j.com', 'mysore') --
                    email = KeyboardUtil.getString("Enter email   : ");
                    city = KeyboardUtil.getString("Enter city    : ");

                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setString(3, email);
                    stmt.setString(4, city);
                    stmt.execute(); // visit the server again, carrying values for all parameters

                    log.debug("sql command executed successfully - {}", sql);
                } catch (Exception e) {
                    log.warn("Error occurred", e);
                }
                choice = KeyboardUtil.getString("Want to add another? (yes/no) [yes] ");
                if (choice.trim().equals("")) {
                    choice = "yes";
                }
            } while (choice.equalsIgnoreCase("yes"));
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}