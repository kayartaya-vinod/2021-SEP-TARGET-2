package co.vinod.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;

    public void setId(int id) throws InvalidIdException {
        if(id<=0){
            throw new InvalidIdException("Invalid value for id");
        }
        this.id = id;
    }

    public void setName(String name) throws NullOrEmptyNameException {
        if(name==null || name.trim().length()==0){
            throw new NullOrEmptyNameException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if(price<0 || price>2000000){
            throw new InvalidPriceException("Invalid value for price");
        }
        this.price = price;
    }
}
