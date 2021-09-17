package co.vinod.training.dao;

import co.vinod.training.entity.Customer;
import co.vinod.training.entity.DaoException;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCustomerDao implements CustomerDao{

    List<Customer> list = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) throws DaoException {
        if(customer==null){
            throw new DaoException("Customer object is null");
        }

        if(customer.getName()==null || customer.getName().trim().length()==0){
            throw new DaoException("Customer name is either null or empty string!");
        }

        list.add(customer);
    }
}
