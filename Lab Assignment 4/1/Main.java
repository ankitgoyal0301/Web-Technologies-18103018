package com.company;
import java.lang.annotation.Documented;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main {

    static int minimumPlants;

    public static boolean isValid(StringBuffer[] cropsTemp, int n, int m){
        boolean valid = true;
        for(int i=1;i<n;++i){
            for(int j=0;j<m;++j){
                if(i!=1){
                    if(cropsTemp[i].charAt(j) == cropsTemp[i-1].charAt(j)){
                        valid = false;
                        break;
                    }
                }
                if(j!=0){
                    if(cropsTemp[i].charAt(j) == cropsTemp[i].charAt(j-1)){
                        valid = false;
                        break;
                    }
                }
                if(i!=n-1){
                    if(cropsTemp[i].charAt(j) == cropsTemp[i+1].charAt(j)){
                        valid = false;
                        break;
                    }
                }
                if(j!=m-1){
                    if(cropsTemp[i].charAt(j) == cropsTemp[i].charAt(j+1)){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid == false) break;
        }
        return valid;
    }

    public static void minimumReplantation(StringBuffer[] crops, StringBuffer[] cropsTemp, int x,int y, int n,int m, int[][] changed){

        if(y==m){
            minimumReplantation(crops,cropsTemp,x+1,0,n,m, changed);
            return;
        }
        if(x==n){
            // Comparison
            int count = 0;
            for(int i=1;i<n;++i){
                for(int j=0;j<m;++j){
                    if(changed[i][j] == 1){
                        count++;
                    }
                }
            }
            if(count<minimumPlants){
                minimumPlants = count;
            }
            return;
        }

        boolean left = false,top = false, down = false, right = false;

        if(x!=1){
            if(cropsTemp[x].charAt(y) == cropsTemp[x-1].charAt(y)){
                top = true;
            }
        }
        if(y!=0){
            if(cropsTemp[x].charAt(y) == cropsTemp[x].charAt(y-1)){
                left = true;
            }
        }
        if(x!=n-1){
            if(cropsTemp[x].charAt(y) == cropsTemp[x+1].charAt(y)){
                down = true;
            }
        }
        if(y!=m-1){
            if(cropsTemp[x].charAt(y) == cropsTemp[x].charAt(y+1)){
                right = true;
            }
        }

        if((top == true && changed[x-1][y]==0)||(left == true && changed[x][y-1]==0)){
            changed[x][y] = 1;
            minimumReplantation(crops,cropsTemp,x,y+1,n,m, changed);
            changed[x][y] = 0;
            return;
        }
        else if(down || right){
            changed[x][y] = 1;
            minimumReplantation(crops,cropsTemp,x,y+1,n,m, changed);
            changed[x][y] = 0;

            if(down) changed[x+1][y] = 1;
            if(right) changed[x][y+1] = 1;

            minimumReplantation(crops,cropsTemp,x,y+1,n,m, changed);

            if(down) changed[x+1][y] = 0;
            if(right) changed[x][y+1] = 0;
        }
        else {
            minimumReplantation(crops,cropsTemp,x,y+1,n,m, changed);
        }
//        if(x==n){
//            // Comparison
//            if(isValid(cropsTemp,n ,m)){
//
//                int count = 0;
//                for(int i=1;i<n;++i){
//                    for(int j=0;j<m;++j){
//                        if(crops[i].charAt(j) != cropsTemp[i].charAt(j)){
//                            count++;
//                        }
//                    }
//                }
//                if(count<minimumPlants){
//                    minimumPlants = count;
//                }
//            }
//            return;
//        }
//
//        char[] ch = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//
//        for(int i=0;i<26;++i){
//            cropsTemp[x].setCharAt(y, ch[i]);
//            minimumReplantation(crops,cropsTemp,x,y+1,n,m, changed);
//        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n, m;

        System.out.println("Enter the number of rows:");
        n = scanner.nextInt();

        System.out.println("Enter the number of columns:");
        m = scanner.nextInt();

        StringBuffer[] crops = new StringBuffer[n+1];
        StringBuffer[] cropsTemp = new StringBuffer[n+1];
        int[][] changed = new int[n+1][m];
        for(int i=1;i<=n;++i){
            for(int j=0;j<m;++j){
                changed[i][j] = 0;
            }
        }

        System.out.println("Enter the Matrix:");
        // Is not taking input at 0, so using <=n inspite of <n
        for (int i = 0; i <= n; i++) {
            //System.out.println("hi: "+i);
            String cropInput = scanner.nextLine().trim();
            crops[i] = new StringBuffer(cropInput);
            cropsTemp[i] = new StringBuffer(cropInput);
        }

        minimumPlants = Integer.MAX_VALUE;
        int x=1,y=0;
        minimumReplantation(crops,cropsTemp, x, y, n+1,m, changed);

        System.out.println("Minimum Replantations required are " + minimumPlants + ".");
    }

}