package co.vinod.training.programs;

import co.vinod.training.entity.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {


    public static void main(String[] args) {

        Customer c;
        Map<Integer, Customer> customers = new HashMap<>();

        c = new Customer(12, "Vinod", "vinod@vinod.co", "Bangalore");
        customers.put(c.getId(), c);
        c = new Customer(22, "Shyam", "shyam@xmpl.com", "Shivamogga");
        customers.put(c.getId(), c);
        c = new Customer(18, "Kiran", "kiran@xmpl.com", "Vasco");
        customers.put(c.getId(), c);
        c = new Customer(87, "John", "john@xmpl.com", "Dallas");
        customers.put(c.getId(), c);
        c = new Customer(22, "Shyam Sundar", "shyamsundar@xmpl.com", "Shivamogga");
        customers.put(c.getId(), c);

//        int id = KeyboardUtil.getInt("Enter id to search: ");
//        if(customers.containsKey(id)){
//            c = customers.get(id);
//            System.out.println(c);
//        }
//        else{
//            System.out.println("No customer for id " + id);
//        }

        System.out.println("Map as a set of keys");
        Set<Integer> keys = customers.keySet();
        System.out.println(keys);
        System.out.println();

        System.out.println("Map as a collection of values");
        Collection<Customer> vals = customers.values();
        for(Customer c1: vals){
            System.out.println(c1);
        }
        System.out.println();

        System.out.println("Map as a set of entries");
        Set<Map.Entry<Integer, Customer>> entries = customers.entrySet();
        for(Map.Entry<Integer, Customer> entry: entries){
            System.out.println(entry.getKey() + " --|> " + entry.getValue());
        }
    }
}
