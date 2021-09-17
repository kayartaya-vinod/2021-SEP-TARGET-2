package co.vinod.training.dao;

import co.vinod.training.entity.Customer;

import java.util.List;

public interface CustomerDao {
    // CRUD operations
    public void addCustomer(Customer customer) throws DaoException;

    public Customer getById(Integer id) throws DaoException;

    public void updateCustomer(Customer customer) throws DaoException;

    // QUERIES
    public List<Customer> getAll() throws DaoException;

    public List<Customer> getByCity(String city) throws DaoException;

    public Customer getByEmail(String email) throws DaoException;
}
