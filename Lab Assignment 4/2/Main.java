package com.company;
import java.lang.annotation.Documented;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int startNumberInt = -1;
        System.out.println("Start Integer Number is: "+startNumberInt);
        byte intToByte = (byte)startNumberInt;
        System.out.println("Start Integer Number after converting to byte becomes: "+intToByte);
        char byteToChar = (char)intToByte;
        System.out.println("Byte Number after converting to char becomes: "+byteToChar);
        int charToInt = (int)byteToChar;
        System.out.println("Char after converting back to int becomes: "+charToInt);

        if(startNumberInt == charToInt){
            System.out.println("The int remained same!!!");
        }
        else{
            System.out.println("The int did not remain same!!!");
        }
    }
}