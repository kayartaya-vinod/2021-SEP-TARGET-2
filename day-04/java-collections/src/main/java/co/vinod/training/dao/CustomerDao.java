package co.vinod.training.dao;

import co.vinod.training.entity.Customer;
import co.vinod.training.entity.DaoException;

public interface CustomerDao {

    public void addCustomer(Customer customer) throws DaoException;

}
