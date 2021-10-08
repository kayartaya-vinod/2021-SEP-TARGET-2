package co.vinod.training.service;

import co.vinod.training.dao.OrderDao;
import co.vinod.training.entity.Customer;
import co.vinod.training.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class DefaultOrderService implements OrderService{

    @Autowired
    private OrderDao dao;

    // read from application.properties or application.yml
    @Value("${microservices.url.customer-service}")
    private String customerServiceUrl;

    @Override
    public Order getOrderById(Integer id) {
        Optional<Order> op = dao.findById(id);
        if(op.isPresent()){
            Order order =  op.get();

            RestTemplate rt = new RestTemplate();

            // go and get customer data by visiting customerServiceUrl
            try{
                // The RestTemplate object can attempt to convert any JSON to the given datatype (i.e, Customer)
                Customer c = rt.getForObject(customerServiceUrl + order.getCustomerId(), Customer.class);
                order.setCustomer(c);
            }
            catch(Exception e){
                log.warn("Exception while trying to get customer data", e);
            }

            return order;
        }
        throw new RuntimeException("No order data found for id " + id);
    }
}
