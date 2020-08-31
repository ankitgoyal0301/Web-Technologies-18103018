package com.company;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        System.out.println("We have fixed our universe, which will consist of the 11 elements, Universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}");
        System.out.print("Enter number of elements in set A: ");
        int n = scanner.nextInt();
        int[] arr1 = new int[n];

        for(int i=0;i<n;++i){
            System.out.print("Enter element "+(i+1)+": ");
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter number of elements in set B: ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];

        for(int i=0;i<m;++i){
            System.out.print("Enter element "+(i+1)+": ");
            arr2[i] = scanner.nextInt();
        }

        // preparing seperate array for part A because my algorithm would sort the array and i don't want to disturb the original array
        int[] arr_1_a =  new int[n];
        System.arraycopy(arr1, 0, arr_1_a, 0, n);
        int[] arr_2_a =  new int[m];
        System.arraycopy(arr2, 0, arr_2_a, 0, m);

        System.out.println();
        // Part - a
        // Starting Time
        long start1 = System.currentTimeMillis();

        System.out.println("Part A:");

        // Sorting arrays
        Arrays.sort(arr_1_a);
        Arrays.sort(arr_2_a);

        // Union
        int ptr1 = 0, ptr2 = 0, count = 0;
        while(ptr1<n && ptr2<m){
            if(arr_1_a[ptr1] == arr_2_a[ptr2]){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            else if(arr_1_a[ptr1] < arr_2_a[ptr2]){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            count++;
        }
        while(ptr1<n){
            int temp = arr_1_a[ptr1];
            while(ptr1<n && temp == arr_1_a[ptr1]){
                ptr1++;
            }
            count++;
        }
        while(ptr2<m){
            int temp = arr_2_a[ptr2];
            while(ptr2<m && temp == arr_2_a[ptr2]){
                ptr2++;
            }
            count++;
        }
        ptr1=ptr2=0;
        int[] resultUnion1 = new int[count];
        int index=0;
        while(ptr1<n && ptr2<m){
            if(arr_1_a[ptr1] == arr_2_a[ptr2]){
                resultUnion1[index] = arr_2_a[ptr2];
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            else if(arr_1_a[ptr1] < arr_2_a[ptr2]){
                resultUnion1[index] = arr_1_a[ptr1];
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                resultUnion1[index] = arr_2_a[ptr2];
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            index++;
        }
        while(ptr1<n){
            resultUnion1[index] = arr_1_a[ptr1];
            int temp = arr_1_a[ptr1];
            while(ptr1<n && temp == arr_1_a[ptr1]){
                ptr1++;
            }
            index++;
        }
        while(ptr2<m){
            resultUnion1[index] = arr_2_a[ptr2];
            int temp = arr_2_a[ptr2];
            while(ptr2<m && temp == arr_2_a[ptr2]){
                ptr2++;
            }
            index++;
        }
        System.out.print("Union: ");
        for(int i=0;i<count;++i){
            System.out.print(resultUnion1[i]+" ");
        }
        System.out.println();

        //Intersection
        ptr1 = ptr2 = count = 0;
        while(ptr1<n && ptr2<m){
            if(arr_1_a[ptr1] == arr_2_a[ptr2]){
                count++;
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            else if(arr_1_a[ptr1] < arr_2_a[ptr2]){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
        }

        ptr1=ptr2=0;
        int[] resultInter1 = new int[count];
        index=0;
        while(ptr1<n && ptr2<m){
            if(arr_1_a[ptr1] == arr_2_a[ptr2]){
                resultInter1[index] = arr_2_a[ptr2];
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
                index++;
            }
            else if(arr_1_a[ptr1] < arr_2_a[ptr2]){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
        }

        System.out.print("Intersection: ");
        for(int i=0;i<count;++i){
            System.out.print(resultInter1[i]+" ");
        }
        System.out.println();

        // Complement of each set

        index = ptr1 = ptr2 = 0;
        int num = 0;
        count=0;
        while(ptr1<n){
            if(arr_1_a[ptr1] == num){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                count++;
            }
            num++;
        }
        while(num<=10){
            count++;
            num++;
        }

        int[] compRes1a = new int[count];
        index = ptr1 = ptr2 = 0;
        num = count = 0;
        while(ptr1<n){
            if(arr_1_a[ptr1] == num){
                int temp = arr_1_a[ptr1];
                while(ptr1<n && temp == arr_1_a[ptr1]){
                    ptr1++;
                }
            }
            else {
                compRes1a[index] = num;
                index++;
            }
            num++;
        }
        while(num<=10){
            compRes1a[index] = num;
            index++;
            num++;
        }

        num = index = 0;
        while(ptr2<m){
            if(arr_2_a[ptr2] == num){
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            else {
                count++;
            }
            num++;
        }
        while(num<=10){
            count++;
            num++;
        }

        int[] compRes1b = new int[count];
        index = ptr1 = ptr2 = 0;
        num = count = 0;
        while(ptr2<m){
            if(arr_2_a[ptr2] == num){
                int temp = arr_2_a[ptr2];
                while(ptr2<m && temp == arr_2_a[ptr2]){
                    ptr2++;
                }
            }
            else {
                compRes1b[index] = num;
                index++;
            }
            num++;
        }
        while(num<=10){
            compRes1b[index] = num;
            index++;
            num++;
        }

        System.out.print("A Complement: ");
        for(int i=0;i<compRes1a.length;++i){
            System.out.print(compRes1a[i]+" ");
        }
        System.out.println();
        System.out.print("B Complement: ");
        for(int i=0;i<compRes1b.length;++i){
            System.out.print(compRes1b[i]+" ");
        }
        System.out.println();

        // ending time
        long end1 = System.currentTimeMillis();
        System.out.println("Time taken: " +
                (end1 - start1) + "ms");

        System.out.println();
        // Part - b
        long start2 = System.currentTimeMillis();

        System.out.println("Part B:");

        int a[]=new int[n];
        int b[]=new int[m];
        HashSet<Integer>  hs =new HashSet<Integer>();
        HashSet<Integer> union=new HashSet<Integer>();
        HashSet<Integer> universal=new HashSet<Integer>();

        for(int i=0;i<=10;i++)
        {
            universal.add(i);
        }
        for(int i=0;i<n;i++)
        {
            a[i]=arr1[i];
            union.add(a[i]);
            hs.add(a[i]);
        }
        for(int i=0;i<m;i++)
        {
            b[i]=arr2[i];
            union.add(b[i]);
        }
        System.out.print("Union: ");
        for(Integer i: union)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("Intersection: ");

        HashSet<Integer> hsDup = new HashSet<Integer>(hs);
        for(int i=0;i<m;i++)
        {
            if(hsDup.contains(b[i]))
            {
                System.out.print(b[i]+" ");
                hsDup.remove(b[i]);
            }
            int temp = b[i];
            while(i<m && temp==b[i]){
                ++i;
            }
            --i;
        }
        System.out.println();

        System.out.print("A Complement: ");

        for(Integer i:universal)
        {
            if(!hs.contains(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.print("B Complement: ");
        for(int i=0;i<m;i++)
        {
            if(universal.contains(b[i]))
            {
                universal.remove(b[i]);
            }
        }
        for(Integer i:universal)
        {
            System.out.print(i+" ");
        }
        System.out.println();

        long end2 = System.currentTimeMillis();
        System.out.println("Time taken: " +
                (end2 - start2) + "ms");

        // Part - c
        System.out.println();
        System.out.println("Part C: ");
        System.out.println("Time taken by Part - a: " + (end1 - start1) + " ms");
        System.out.println("Time taken by Part - b: " + (end2 - start2) + " ms");
    }
}