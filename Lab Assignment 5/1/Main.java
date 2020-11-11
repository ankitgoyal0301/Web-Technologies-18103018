package com.company;
import java.util.*;
import java.io.*;

class Count extends Thread {
    public void run(){
        for(int i=1;i<=100;i++) {
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            System.out.println("Number: " + i);
            if(i%10 == 0){
                System.out.println(i + " numbers counted!!!");
            }
        }
    }
}

public class Main {

    public static void main(String[] args){

        Count count = new Count();

        System.out.println("Thread Started!!!");
        count.start();
        
        try{
            count.join();
        }catch(Exception e){};

        System.out.println("Thread Finished!!!");
    }

}