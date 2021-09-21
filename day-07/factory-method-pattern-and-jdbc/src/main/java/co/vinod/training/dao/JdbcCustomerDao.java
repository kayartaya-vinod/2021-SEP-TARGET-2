package co.vinod.training.dao;

import co.vinod.training.entity.Customer;

import java.util.List;

public class JdbcCustomerDao implements CustomerDao{
    @Override
    public void addCustomer(Customer customer) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public Customer getById(Integer id) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }
}
