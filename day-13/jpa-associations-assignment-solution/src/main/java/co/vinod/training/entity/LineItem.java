package co.vinod.training.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ORDER_DETAILS")
public class LineItem {// implements Serializable {
//    @Id
//    @Column(name="ORDER_ID")
//    private Integer orderId;
//    @Id
//    @Column(name="PRODUCT_ID")
//    private Integer productId;
    @EmbeddedId
    private LinkeItemPK key;

    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID", insertable = false, updatable = false)
    private Product product;


}
