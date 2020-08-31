package com.company;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        long ans = 0L;

        for(long i=1L ; i<=Integer.MAX_VALUE ; ++i){
            long lhs = ((i)*(i+1))/2;
            long rhs = i*i;

            if(lhs == rhs){
                ans = i;
            }
        }
        System.out.println("The smallest n such that Σi = i2 where 1 ≤ i ≤ n is too large to be represented as an int is: " + ans);

        /*
        // 2147516416

        // Method 1
        long num = 0L;
        long maxi = Integer.MAX_VALUE;

        long i = 1;

        while(num<=maxi){
            num += i;
            ++i;
        }
        System.out.println("Method 1: The smallest n such that Σi = i2 where 1 ≤ i ≤ n is too large to be represented as an int is "+num);

        // Method 2
        double maxi2 = Integer.MAX_VALUE;

        double n2 = Math.ceil((Math.sqrt(1+8*maxi2)-1)/2.0);
        long num2 = (long)n2;
        long value = (num2*(num2+1))/2;

        System.out.println("Method 2: The smallest n such that Σi = i2 where 1 ≤ i ≤ n is too large to be represented as an int is "+ value);
        */
    }
}
