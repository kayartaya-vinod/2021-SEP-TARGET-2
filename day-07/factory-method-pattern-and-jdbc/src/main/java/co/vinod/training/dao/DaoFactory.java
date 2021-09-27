package co.vinod.training.dao;

import java.util.ResourceBundle;

public final class DaoFactory {

    // don't let anyone instantiate this class
    private DaoFactory() {
    }

    private static CustomerDao dao = null;

    public static CustomerDao getCustomerDao() throws DaoException {

        if (dao != null) return dao;

        ResourceBundle rb = ResourceBundle.getBundle("customer-dao-impl");
        String discriminator = rb.getString("discriminator");
        switch (discriminator.toLowerCase()) {
            case "arraylist":
                dao = new ArrayListCustomerDao();
                break;
            case "jdbc":
                dao = new JdbcCustomerDao();
                break;
            case "hashmap":
                dao= new HashMapCustomerDao(); break;
            case "jpa":
            case "csv":
            default:
                throw new DaoException("CustomerDao implementation using " + discriminator + " is not available");
        }
        return dao;
    }
}
