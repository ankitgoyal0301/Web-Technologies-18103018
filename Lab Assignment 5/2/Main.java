package com.company;
import java.util.*;
import java.io.*;

class CountDivisors extends Thread{

    private volatile static int maxDivisorCount = 0;
    private volatile static int intWithMaxDivisorCount;

    int start = -1,end=-1;

    synchronized private static void report(int maxCountFromThread,int intWithMaxFromThread) {
        if (maxCountFromThread > maxDivisorCount) {
            maxDivisorCount = maxCountFromThread;
            intWithMaxDivisorCount = intWithMaxFromThread;
        }
    }

    public int divisors(int num){
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0) {
                if (num / i == i) {
                    count++;
                }
                else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public void setValue(int s,int e){
        this.start = s;
        this.end = e;
    }

    public void run(){

        for(int i = start ; i <= end ; ++i){
//            System.out.println(i);
//            try{
//                Thread.sleep(500);
//            }
//            catch (Exception e){}
            int num = divisors(i);
            report(num,i);
        }
    }
    public static void getAnswer(){
        System.out.println("The largest number of divisors for numbers between 1 and 100000 is "+ maxDivisorCount + ".");

        System.out.println("An integer with that many divisors is "+ intWithMaxDivisorCount + ".");
    }
}

public class Main {

    public static void main(String[] args){

        long startTime = System.nanoTime();

        CountDivisors[] thread = new CountDivisors[10];
        int start=1,end = 10000;
        int num=0;
        while(num<10){
            thread[num] = new CountDivisors();
            thread[num].setValue(start,end);
            num++;
            start += 10000;
            end += 10000;
        }

        System.out.println("Counting divisors using 10 threads...");
        System.out.println();

        for(int i=0;i<10;++i){
            System.out.println("Thread "+(i+1)+" started!!!");
            thread[i].start();
        }

        System.out.println();

        for(int i=0;i<10;++i){
            try{
                thread[i].join();
                System.out.println("Thread "+(i+1)+" finished!!!");
            }
            catch(Exception e){};
        }

        System.out.println();

        CountDivisors.getAnswer();

        long endTime   = System.nanoTime();
        double totalTime = (endTime - startTime)/1000000000.0;

        System.out.println();

        System.out.println("Total elapsed time: "+totalTime + " seconds.");


    }
}