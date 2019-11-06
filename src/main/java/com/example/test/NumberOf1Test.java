package com.example.test;

public class NumberOf1Test {

    public static void main(String[] args){

//        System.out.println(NumberOf1(-5));
        System.out.println(Power(2.22,-1));
    }

    public static int NumberOf1(int n) {
        int result = 0;
        char[] binary = Integer.toBinaryString(n).toCharArray();
        for (char c:binary) {
            if('1'== c){
                result ++;
            }
        }
        return result;
    }

    public static double Power(double base, int exponent) {
        if(exponent == 0 ){
            return 1;
        }else if(base == 0){
            return 0;
        }
//        else if(exponent == 1 ){
//            return base;
//        }
        else {
            if(exponent <0){
                base = 1/base;
                exponent = -exponent;
            }
                return  base * (Power(base,exponent-1));

        }

    }
}
