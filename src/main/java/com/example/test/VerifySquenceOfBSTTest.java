package com.example.test;

public class VerifySquenceOfBSTTest {

    public static void main(String[] args){

//        char[] arr1 = new char[]{'a','b','c','d','e','f','g','h','i','j','k'};
//        char[] arr2 = new char[]{'r','t','y','u','o'};
//        printArray(arr1);//先打印arr1方法
//        printArray(arr2);//打印arr2方法
//        System.arraycopy(arr2,1,arr1,0,3);//调用copy方法
//        printArray(arr1);//重新打印arr1方法
        int[] i = {};
        System.out.println(VerifySquenceOfBST(i));
    }

    //打印数组方法
    public static void printArray(char[] arr1){
        for(int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i]+"\t");
        }
        System.out.println();
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        int i = 0;
        int root = sequence[sequence.length-1];
        while(sequence[i] < root){
            i++;
        }
        int j = i;
        while (j <sequence.length-1){
            if(sequence[j] < root){
                return false;
            }else {
                j++;
            }
        }
        int[] left = new int[i];
        int[] right = new int[sequence.length-i-1];
        System.arraycopy(sequence,0,left,0,i);
        System.arraycopy(sequence,i,right,0,j-i);
        return (left.length == 0 ||VerifySquenceOfBST(left)) && (right.length == 0 ||VerifySquenceOfBST(right));
    }
}
