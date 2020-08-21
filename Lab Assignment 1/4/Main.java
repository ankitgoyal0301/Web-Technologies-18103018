package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	   // write your code here
        // Creating Scanner Object
        Scanner scanner = new Scanner(System.in); 
        
        // Taking string input
        System.out.print("Enter String 1: ");
        String s = scanner.next();
        System.out.print("Enter String 2: ");
        String r = scanner.next();

        // Checking for anagrams
        if(s.length()!=r.length()) {
            System.out.println("The Given Strings are not Anagrams!");
        }
        else {
            char[] temp1 = s.toCharArray();
            Arrays.sort(temp1);
            s = new String(temp1);

            char[] temp2 = r.toCharArray();
            Arrays.sort(temp2);
            r = new String(temp2);

            boolean same = true;
            for(int i=0;i<s.length();++i)
            {
                if(s.charAt(i) != r.charAt(i))
                {
                    same = false;
                    break;
                }
            }
            if(same){
                System.out.println("The Given Strings are Anagrams!");
            }
            else {
                System.out.println("The Given Strings are not Anagrams!");
            }
        }
    }
}
