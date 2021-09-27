package co.vinod.training.dao;

import co.vinod.training.entity.Customer;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapCustomerDao implements CustomerDao{

    Map<Integer, Customer> customers = new LinkedHashMap<>();

    @Override
    public void addCustomer(Customer customer) throws DaoException {
        // after the validations...
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer getById(Integer id) throws DaoException {
        return customers.get(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        throw new DaoException("Method not implemented yet");
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        List<Customer> list = new ArrayList<>(customers.size());
        list.addAll(customers.values());
        return list;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        return customers
                .values()
                .stream()
                .filter(c->c.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        // after validation of email...
        Optional<Customer> op = customers.values().stream().filter(c -> c.getEmail().equals(email)).findFirst();
        return op.isPresent()?op.get(): null;
    }
}
