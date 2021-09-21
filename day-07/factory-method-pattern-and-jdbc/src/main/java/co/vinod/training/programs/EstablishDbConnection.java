package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class EstablishDbConnection {
    @SneakyThrows
    public static void main(String[] args) {

        log.debug("Following drivers have been registered with DriverManager:");
        DriverManager
                .drivers()
                .forEach(d -> log.debug("{}", d.getClass().getName()));

        String url = "jdbc:h2:tcp://localhost/~/target_batch2_db"; // jdbc:mysql://localhost/target_batch2_db
        String username = "root";
        String password = "Welcome#123";

        // DriverManger.getConnection does not create the new connection, but it delegates that work to
        // a suitable driver object (such as org.h2.Driver), which accepts the given URL
        Connection conn = DriverManager.getConnection(url, username, password);

        log.debug("Got an instanceof {} for variable conn", conn.getClass().getName());
        conn.close();
    }
}
