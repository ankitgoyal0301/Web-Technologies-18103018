package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static boolean match(String s, int startIndex, String vectorStr) {

        for(int i=0;i<vectorStr.length();++i) {
            if(s.charAt(i+startIndex) != vectorStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the paragraph and press Enter when done: ");
        String s = scanner.nextLine();
        System.out.print("Enter the number of elements in vector: ");
        int n = scanner.nextInt();

        String[] vector = new String[n];

        for(int i=0;i<n;++i)
        {
            System.out.print("Enter string number "+ (i+1) + ": ");
            vector[i]= scanner.next();
        }

        String finString = new String();

        for(int i=0;i<s.length();++i)
        {
            boolean included = false;
            for(int j=0;j<n;++j)
            {
                if(match(s,i,vector[j]))
                {
                    finString += vector[j].charAt(0);
                    for(int k=1;k<vector[j].length();++k)
                    {
                        finString += '*';
                        ++i;
                    }
                    included = true;
                    break;
                }
            }
            if(!included) {
                finString += s.charAt(i);
            }
        }
        System.out.println("The final resultant string is " + finString);
    }
}
