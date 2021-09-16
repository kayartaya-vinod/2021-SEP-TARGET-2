package co.vinod.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Comparable<Person> {
    private String name;
    private String city;
    private int age;
    private double height;

    // provides natural ordering for Person objects
    @Override
    public int compareTo(Person other) {
        int c = this.name.compareTo(other.name);
        if(c==0){
            c = this.city.compareTo(other.city);
            if(c==0){
                c = this.age - other.age;
                if(c==0){
                    return Double.compare(this.height, other.height);
                }
            }
        }
        return c;
    }
}
