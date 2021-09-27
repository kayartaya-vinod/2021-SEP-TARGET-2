package co.vinod.training.dao;

import co.vinod.training.entity.Customer;
import co.vinod.training.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {
    private static final String METHOD_NOT_IMPLEMENTED_YET = "Method not implemented using JDBC yet!";

    @Override
    public void addCustomer(Customer customer) throws DaoException {
        String sql = "insert into customers values (?, ?, ?, ?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // sql insert command without values goes to the server
        ) {
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getCity());
            stmt.execute(); // visit the server again, carrying values for all parameters
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(Integer id) throws DaoException {
        String sql = "select * from customers where id=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    Customer c = new Customer();
                    c.setId(id);
                    c.setName(rs.getString("name"));
                    c.setEmail(rs.getString("email"));
                    c.setCity(rs.getString("city"));
                    return c;
                }
            }
        } catch (Exception e) {
            throw new DaoException(e); // decorator pattern; wrap one type of exception with another
        }

        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        String sql = "update customers set name=?, email=?, city=? where id=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getCity());
            stmt.setInt(4, customer.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e); // decorator pattern; wrap one type of exception with another
        }
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        List<Customer> list = new ArrayList<>();
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
                Customer c = new Customer(id, name, email, city);
                list.add(c);
            }

        } catch (Exception e) {
            throw new DaoException(e); // decorator pattern; wrap one type of exception with another
        }
        return list;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        throw new DaoException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        throw new DaoException(METHOD_NOT_IMPLEMENTED_YET);
    }
}
