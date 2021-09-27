package co.vinod.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity // now EntityManager can manage objects of this class
@Table(name = "employees") // in the absence of this annotation, table with a name same as classname will be mapped
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "hire_date")
    private Date hireDate;
    private Double salary;
    @Column(unique = true)
    private String email;
    private String city;
    private String state;
    private String country;

    public Employee(Integer id, String name, Date hireDate, Double salary, String email) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
        this.email = email;
    }

    public Employee(String name, Double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }
}
