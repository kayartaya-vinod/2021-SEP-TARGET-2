package co.vinod.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID") // column in the CATEGORIES table
    private Integer categoryId;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    private String description;
    private byte[] picture;

    @OneToMany // LAZY fetch by default
    @JoinColumn(name = "CATEGORY_ID") // CATEGORY_ID here is the column in PRODUCTS TABLE
    private List<Product> productList;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
