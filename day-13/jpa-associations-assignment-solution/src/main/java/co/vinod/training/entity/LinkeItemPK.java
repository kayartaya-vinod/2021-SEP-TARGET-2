package co.vinod.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkeItemPK implements Serializable {
    @Column(name="ORDER_ID")
    private Integer orderId;
    @Column(name="PRODUCT_ID")
    private Integer productId;
}
