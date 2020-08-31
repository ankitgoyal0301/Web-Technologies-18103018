package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static boolean checkString(String s1, String s2) {

        for(int i=0;i<s1.length() && i<s2.length();++i){
            if((int)s1.charAt(i) < (int)s2.charAt(i)){
                return false;
            }
            else if((int)s1.charAt(i) > (int)s2.charAt(i)) {
                return true;
            }
        }

        if(s1.length()<=s2.length()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings in array: ");
        int n = scanner.nextInt();
        String[] str = new String[n];

        System.out.println("Enter the strings(in lowercase): ");

        for(int i=0;i<n;++i){
            System.out.print("Enter string "+(i+1)+": ");
            str[i] = scanner.next();
        }

        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                if(checkString(str[i],str[j])){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        System.out.println("After Sorting, Strings are in the order as shown: ");
        for(int i=0;i<n;++i){
            System.out.print(str[i]+" ");
        }
        System.out.println();
    }
}
