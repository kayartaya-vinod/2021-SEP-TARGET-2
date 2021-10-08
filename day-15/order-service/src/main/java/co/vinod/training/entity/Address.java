package co.vinod.training.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String region;
    private String postalCode;
    private String country;
}
