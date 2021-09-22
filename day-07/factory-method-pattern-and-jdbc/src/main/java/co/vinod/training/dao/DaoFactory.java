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
            case "jpa":
                // dao= new JpaCustomerDao(); break;
            case "hashmap":
                 dao= new HashMapCustomerDao(); break;
            case "csv":
                // dao= new CsvCustomerDao(); break;
            default:
                throw new DaoException("CustomerDao implemention using " + discriminator + " is not available");
        }
        return dao;
    }
}
