package com.kvinod.training.programs;

import java.util.Scanner;

public class PrintTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int num = sc.nextInt();
        int limit = 10;
        for(int i=1; i<=limit; i++){
            System.out.printf("%d X %d = %d\n", num, i, num*i);
        }

    }
}
