package co.vinod.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @JsonIgnore
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Transient // JPA doesn't care about this now!
    private Customer customer;

    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;
    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;
    private Double freight;
    @Column(name = "SHIP_NAME")
    private String shipName;
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column(name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_REGION")
    private String shipRegion;
    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;
    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;

    // A LIST OF LINE-ITEMS
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="ORDER_ID")
    private List<LineItem> lineItems;

}
