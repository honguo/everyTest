package com.example.test;

public class ReOrderArrayTest {

    public static void main(String[] args){
        int[] aa = {2,3,4,5,6};
        for (int i:reOrderArray(aa)
             ) {
            System.out.println(i+",");
        }
    }

    public static int[] reOrderArray(int [] array) {
        int[] array2 = new int[array.length];
        int[] array3 = new int[array.length];
        int array2length = 0;
        int array3length = 0 ;
        for (int i:array
             ) {
            if (i%2 == 0){
                array3[array3length] = i;
                array3length++;
            }else {
                array2[array2length] = i;
                array2length ++;
            }
        }
        for (int j=0;j<array2length;j++){
            array[j] = array2[j];
        }
        for (int k=0;k<array3length;k++){
            array[array2length+k] = array3[k];
        }
        return array;

    }
}
