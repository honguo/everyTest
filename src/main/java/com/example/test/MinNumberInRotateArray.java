package com.example.test;

public class MinNumberInRotateArray {

    public static void main(String[] args){
        int[] a = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int j= array[0];
        for(int i=0;i<array.length;i++){
            if(j>array[i]){
                return array[i];
            }
        }
        return 0;
    }
}
