package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static int compareString(String s1, String s2) {

        for(int i=0;i<s1.length() && i<s2.length();++i){
            if((int)s1.charAt(i) == (int)s2.charAt(i)){
                continue;
            }
            else return (int)s1.charAt(i)-(int)s2.charAt(i);
        }

        if(s1.length()<s2.length()){
            return s1.length()-s2.length();
        } else if(s1.length()>s2.length()){
            return s1.length()-s2.length();
        } else return 0;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String s1 = scanner.next();
        System.out.print("Enter Second String: ");
        String s2 = scanner.next();

        System.out.println(compareString(s1,s2));

    }
}
