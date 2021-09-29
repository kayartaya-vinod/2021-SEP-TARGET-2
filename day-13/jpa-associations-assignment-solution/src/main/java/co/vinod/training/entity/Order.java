package co.vinod.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
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

    // MANY ORDERS ARE PLACED BY ONE CUSTOMER
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    // A LIST OF LINE-ITEMS
    @OneToMany
    @JoinColumn(name="ORDER_ID")
    private List<LineItem> lineItems;

}
