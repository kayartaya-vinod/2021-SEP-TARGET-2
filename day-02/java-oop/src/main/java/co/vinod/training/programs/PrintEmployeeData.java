package co.vinod.training.programs;

import co.vinod.training.model.Employee;

public class PrintEmployeeData {
    public static void main(String[] args) {

        Employee e1; // Employee IS-A Person

        e1 = new Employee();
        e1.setName("Scott");
        e1.setAge(33);
        e1.setHeight(5.6);
        e1.getAddress().setCity("Dallas");
        e1.setId(1122);
        e1.setSalary(4500.0);

        System.out.println(e1);
    }
}
