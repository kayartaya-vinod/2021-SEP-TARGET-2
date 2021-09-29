package co.vinod.training.programs;

import co.vinod.training.entity.Customer;
import co.vinod.training.entity.LineItem;
import co.vinod.training.entity.Order;
import co.vinod.training.utils.JpaUtil;
import co.vinod.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GetFullOrderInformation {

    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter order id: ");
        EntityManager em = JpaUtil.createEntityManager();

        Order order = em.find(Order.class, orderId);

        printOrderInformation(order);

        printCustomerInformation(order);
//        printEmployeeInformation(order);
//        printShipperInformation(order);
        printLineItems(order);

        em.close();
    }

    static void printLineItems(Order order) {
        List<LineItem> items = order.getLineItems();
        System.out.println("Products in this order.");
        System.out.println();
        System.out.printf("%-40s %10s %10s %10s %10s%n",
                "Product name", "Unit price", "Quantity", "Subtotal", "Savings");
        line('-');
        double total = 0, totalSaved = 0;
        for(LineItem i: items){
            System.out.printf("%-40s %10.2f %10s %10.2f %10.2f%n",
                    i.getProduct().getProductName(),
                    i.getUnitPrice(),
                    i.getQuantity(),
                    i.getUnitPrice()*i.getQuantity()*(1-i.getDiscount()),
                    i.getUnitPrice()*i.getQuantity()*i.getDiscount());
            total += i.getUnitPrice()*i.getQuantity()*(1-i.getDiscount());
            totalSaved += i.getUnitPrice()*i.getQuantity()*i.getDiscount();
        }
        line('-');
        System.out.printf("%62s %10.2f %10.2f%n", "Total: ", total, totalSaved);
        line('=');
    }

    static void printCustomerInformation(Order order) {
        Customer c = order.getCustomer();
        System.out.println("Customer ID                         : " + c.getCustomerId());
        System.out.println("Company name                        : " + c.getCompanyName());
        System.out.println("Contact person                      : " + c.getContactName());
        System.out.println("Job title                           : " + c.getContactTitle());
        System.out.println("Address                             : " + c.getAddress()
                + " " + c.getCity() + " " + c.getRegion() + " " + c.getCountry() + " " + c.getPostalCode());
        line('-');
    }

    static void line(char ch){
        for(int i=0; i<90; i++){
            System.out.print(ch);
        }
        System.out.println();
    }


    static void printOrderInformation(Order order) {
        line('-');
        System.out.println("Order ID                            : " + order.getOrderId());
        System.out.println("Order date                          : " + order.getOrderDate());
        System.out.println("Required date                       : " + order.getRequiredDate());
        if(order.getShippedDate()!=null)  {
            System.out.println("Shipped date                        : " + order.getShippedDate());
        }
        System.out.println("Freight charges                     : " + order.getFreight());
        line('-');
        System.out.println("Shipping details.");

        System.out.println("Shipping to                         : " + order.getShipName());
        System.out.println("                                      " + order.getShipAddress());
        System.out.println("                                      " + order.getShipCity());
        if(order.getShipRegion()!=null) {
            System.out.println("                                      " + order.getShipRegion());
        }
        System.out.println("                                      " + order.getShipCountry() + " - " + order.getShipPostalCode());
        line('-');
    }
}
