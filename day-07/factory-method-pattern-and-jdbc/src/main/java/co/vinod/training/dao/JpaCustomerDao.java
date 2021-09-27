package co.vinod.training.dao;

import co.vinod.training.entity.Customer;

import java.util.List;

public class JpaCustomerDao implements CustomerDao{
    @Override
    public void addCustomer(Customer customer) throws DaoException {

    }

    @Override
    public Customer getById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {

    }

    @Override
    public List<Customer> getAll() throws DaoException {
        return null;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        return null;
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        return null;
    }
}
