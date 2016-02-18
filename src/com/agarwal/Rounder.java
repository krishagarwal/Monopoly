package com.agarwal;

public class Rounder {
    public int roundToNearestTens(int num){

        int digit = num % 10;
        if (digit >= 5){
            for (int i = 0; i < 10 - digit; i++){
                num++;
            }
        }
        else{
            for (int i = digit; i > 0; i--){
                num--;
            }
        }
        return num;
    }
}
