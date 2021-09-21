package co.vinod.training.programs;

import co.vinod.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateCustomerTable {

    public static void main(String[] args) {
        String sql = "create table customers (\n" +
                "    id integer primary key,\n" +
                "    name varchar(50) not null,\n" +
                "    email varchar(100) not null unique,\n" +
                "    city varchar(50) default 'Bangalore'\n" +
                ")";

        try (
                Connection conn = DbUtil.createConnection(); // equivalent of a bridge (or a cable)
                Statement stmt = conn.createStatement(); // equivalent of the cable car
        ) {
            stmt.execute(sql);  // carries the sql command and gives the same to the RDBMS server for execution
            log.debug("SQL '{}' executed successfully", sql);
        } catch (Exception e) {
            log.error("Error while dealing with DB", e);
        }
    }
}
