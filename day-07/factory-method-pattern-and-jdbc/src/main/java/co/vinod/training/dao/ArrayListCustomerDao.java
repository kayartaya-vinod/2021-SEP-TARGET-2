package co.vinod.training.dao;

import co.vinod.training.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListCustomerDao implements CustomerDao {

    List<Customer> list = new ArrayList<>();

    public ArrayListCustomerDao() {
        list.add(new Customer(12, "Vinod", "vinod@vinod.co", "Bangalore"));
        list.add(new Customer(22, "Shyam", "shyam@xmpl.com", "Shivamogga"));
        list.add(new Customer(18, "Kiran", "kiran@xmpl.com", "Vasco"));
    }

    @Override
    public void addCustomer(Customer customer) throws DaoException {

        // violation of SRP.
        // Fix - by shifting the validation code to the service layer

        if (customer == null) {
            throw new DaoException("Cannot add null customer");
        }
        if (customer.getId() == null || customer.getId() <= 0) {
            throw new DaoException("Customer id cannot be null, 0 or negative!");
        }
        Optional<Customer> cust = list.stream().filter(c -> c.getId() == customer.getId()).findAny();
        if (cust.isPresent()) {
            throw new DaoException("Customer with id " + customer.getId() + " already exists!");
        }
        cust = list.stream().filter(c -> c.getEmail().equals(customer.getEmail())).findAny();
        if (cust.isPresent()) {
            throw new DaoException("Customer with email " + customer.getEmail() + " already exists!");
        }

        list.add(customer);
    }

    @Override
    public Customer getById(Integer id) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        return this.list;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }
}
