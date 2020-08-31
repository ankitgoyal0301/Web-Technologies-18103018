package com.company;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long number = scanner.nextLong();
        int count = 0; // define steps it takes to get to 1 as count and initialize at 0

        if (number <= 1) {
            System.out.println("Please enter a number larger than 1.");
        }

        while (number != 1) {

            if ((number % 2) == 0) {
                long evenNum = number;
                long halfNum = (evenNum / 2);
                System.out.println(evenNum + " is even, so I take half: " + halfNum);
                number = halfNum;

            } else {
                long oddNum = number;
                long tripleOne = ((3 * number) + 1);
                if(tripleOne>Integer.MAX_VALUE){
                    System.out.println("Integer Overflow Detected!!!");
                    return;
                }
                System.out.println(oddNum + " is odd, so I make 3n+1: " + tripleOne);
                number = tripleOne;

            }
            count++; //increment counter 1 for every while loop
        }

        System.out.println("You've reached the number 1, I'm stopping.");
        System.out.println("The process took " + count + " steps to reach 1.");
    }
}
