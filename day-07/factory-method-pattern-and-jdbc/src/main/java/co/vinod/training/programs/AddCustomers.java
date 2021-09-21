package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class AddCustomers {
    public static void main(String[] args) {
        int id;
        String name;
        String email;
        String city;
        String choice;

        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {
            do {
                try {
                    id = KeyboardUtil.getInt("Enter id      : ");
                    name = KeyboardUtil.getString("Enter name    : "); // Vijay', 'v@j.com', 'mysore') --
                    email = KeyboardUtil.getString("Enter email   : ");
                    city = KeyboardUtil.getString("Enter city    : ");

                    String sql = String.format("insert into customers values(%d, '%s', '%s', '%s')",
                            id, name, email, city);
                    stmt.execute(sql);
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
