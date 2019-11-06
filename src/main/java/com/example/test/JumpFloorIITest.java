package com.example.test;

public class JumpFloorIITest {

    public static void main(String[] args){
        System.out.println(JumpFloorII(4));
    }

    public static int JumpFloorII(int target) {

        if(target == 0 || target == 1){
            return 1;
        }else {
            return JumpFloorII(target-1)*2;
        }
    }

}
