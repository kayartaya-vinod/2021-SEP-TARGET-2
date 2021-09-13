package com.kvinod.training.utils;

import java.util.Scanner;

public class KeyboardUtil {

    // if a function/method is static, it should be called using the classname
    // like: KeyboardUtil.getInt("Enter a number: ")
    public static int getInt(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getString(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static double getDouble(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
