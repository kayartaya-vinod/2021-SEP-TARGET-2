package co.vinod.training.programs;

import co.vinod.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlInjectionSimulation {
    public static void main(String[] args) {
        String username;
        String password;
        username = KeyboardUtil.getString("Username: "); // enter --> hacker' or 1=1 --
        password = KeyboardUtil.getString("Password: "); // enter --> anything you want
        String sql = String.format("select * from users where username='%s' and password='%s'", username, password);
        // solution to this sql-injection problem:
        // use parameterized command executor (PreparedStatement)
        log.debug("sql - {}", sql);
    }
}
