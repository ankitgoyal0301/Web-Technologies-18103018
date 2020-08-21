package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static boolean next_permutation(char[] substr,int n) {

        int ind = -1;
        for(int i=n-2;i>=0;--i) {
            if(substr[i] < substr[i+1])
            {
                ind = i;
                break;
            }
        }
        if(ind==-1) return false;

        int start=ind+1, last = n-1;
        while(start < last) {
            char temp = substr[start];
            substr[start] = substr[last];
            substr[last] = temp;
            last--;
            start++;
        }

        for(int i=ind+1;i<n;++i)
        {
            if(substr[ind]<substr[i])
            {
                char temp = substr[ind];
                substr[ind] = substr[i];
                substr[i] = temp;
                break;
            }
        }
        return true;
    }

    public static int substringSearch(String mainstr,char[] substr,int n) {

        int ans=0;
        for(int i=0;i<mainstr.length()-n+1;++i)
        {
            boolean included = true;
            for(int j=0;j<n;++j) {
                if(mainstr.charAt(i+j) != substr[j]) {
                    included = false;
                    break;
                }
            }
            if(included) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String mainstr = scanner.next();
        System.out.print("Enter the Sub-String: ");
        String substring = scanner.next();
        int len = substring.length();

        char[] substr = substring.toCharArray();
        Arrays.sort(substr);

        int ans = 0;

        do {

            ans += substringSearch(mainstr,substr,len);

        } while(next_permutation(substr,len));

        System.out.println("The substring exists "+ans+" number of times in the main string.");
    }
}
