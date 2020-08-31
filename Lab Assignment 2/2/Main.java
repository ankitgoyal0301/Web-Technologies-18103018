package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array in the range(0-20): ");

        for(int i=0;i<n;++i){
            System.out.print("Enter element "+(i+1)+": ");
            arr[i] = scanner.nextInt();
        }

        int[] countSort = new int[21];

        for(int i=0;i<n;++i){
            countSort[arr[i]]++;
        }

        int index = 0;
        for(int i=0;i<=20;++i){
            for(int j=0;j<countSort[i];++j){
                arr[index] = i;
                index++;
            }
        }
        System.out.println("After applying Counting Sort, Elements are in the order as shown: ");
        for(int i=0;i<n;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
