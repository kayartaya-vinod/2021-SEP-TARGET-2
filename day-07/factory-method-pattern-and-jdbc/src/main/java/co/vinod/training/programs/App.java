package co.vinod.training.programs;

import co.vinod.training.dao.CustomerDao;
import co.vinod.training.dao.DaoException;
import co.vinod.training.dao.DaoFactory;
import co.vinod.training.entity.Customer;
import co.vinod.training.utils.KeyboardUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
        new App().start();
    }

    private CustomerDao dao;

    void start() {
        // at compile time, App depends on ArrayListCustomerDao
        // Avoid this by replacing this code with a factory method
        // dao = new ArrayListCustomerDao(); // tight coupling
        try {
            dao = DaoFactory.getCustomerDao();
        } catch (DaoException e) {
            System.out.println("Error while trying get an instanceof CustomerDao - " + e.getMessage());
            return;
        }

        int choice;

        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    acceptAndAddCustomerData();
                    break;
                case 2:
                    listAllCustomers();
                    break;
                case 3:
                    System.out.println("Search by id - TDB");
                    break;
                case 4:
                    System.out.println("Search by email - TDB");
                    break;
                case 5:
                    System.out.println("Search by city - TDB");
                    break;
                case 6:
                    acceptAndUpdateCustomerData();
            }
        }

        System.out.println("Bye!");
    }

    private void acceptAndUpdateCustomerData() {
        try {
            int id = KeyboardUtil.getInt("Enter customer id to search: ");
            Customer c = dao.getById(id);
            if (c == null) {
                System.out.println("No customer data found for id " + id);
                return;
            }

            System.out.println("Please input new details for customer. Hit RETURN to keep old value.");

            String input;
            boolean changed = false;

            input = KeyboardUtil.getString("Enter name: (" + c.getName() + ") ");
            if (!input.trim().equals("")) {
                c.setName(input);
                changed = true;
            }
            input = KeyboardUtil.getString("Enter email: (" + c.getEmail() + ") ");
            if (!input.trim().equals("")) {
                c.setEmail(input);
                changed = true;
            }
            input = KeyboardUtil.getString("Enter city: (" + c.getCity() + ") ");
            if (!input.trim().equals("")) {
                c.setCity(input);
                changed = true;
            }

            if (changed) {
                dao.updateCustomer(c);
                System.out.println("Data updated successfully for id " + id);
            } else {
                System.out.println("Nothing changed, not updating!");
            }

        } catch (Exception e) {
            System.out.println("Only number is allowed for id!");
        }
    }

    private void acceptAndAddCustomerData() {
        try {
            Integer id = KeyboardUtil.getInt("Enter id    : ");
            String name = KeyboardUtil.getString("Enter name  : ");
            String email = KeyboardUtil.getString("Enter email : ");
            String city = KeyboardUtil.getString("Enter city  : ");

            Customer customer = new Customer(id, name, email, city);
            dao.addCustomer(customer);
            System.out.println("New customer data added successfully!");
        } catch (Exception e) {
            System.out.println("There was an error while adding new customer: " + e.getMessage());
        }
    }

    void line(char ch) {
        for (int i = 1; i <= 80; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private void listAllCustomers() {
        try {
            List<Customer> list = dao.getAll();
            line('-');
            System.out.printf("%-5s %-25s %-30s %-25s\n", "ID", "Name", "Email", "City");
            line('-');
            for (Customer c : list) {
                System.out.printf("%-5s %-25s %-30s %-25s\n", c.getId(), c.getName(), c.getEmail(), c.getCity());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("There was an error while trying to get all customers  - " + e.getMessage());
        }
    }

    int menu() {
        int choice = -1;
        do {
            System.out.println("0. Exit");
            System.out.println("1. Add new customer");
            System.out.println("2. List all customers");
            System.out.println("3. Search by id");
            System.out.println("4. Search by email");
            System.out.println("5. Search by city");
            System.out.println("6. Update customer data");

            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if (choice < 0 || choice > 6) {
                    System.out.println("Invalid choice; Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice; Please try again.");
            }

        } while (choice < 0 || choice > 6);
        return choice;
    }
}
