package com.kvinod.training.programs;

import com.kvinod.training.utils.KeyboardUtil;

import java.util.Scanner;

public class GetAndShowPersonData {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = KeyboardUtil.getString("What's your name? ");
        int age = KeyboardUtil.getInt("How old are you? ");
        String city = KeyboardUtil.getString("Where are you from? ");
        double height = KeyboardUtil.getDouble("How tall/short are you? ");

        System.out.printf("%s from %s is %d years old and is %.2f ft tall!\n", name, city, age, height);

    }
}
