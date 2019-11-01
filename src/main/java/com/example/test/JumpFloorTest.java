package com.example.test;

public class JumpFloorTest {

    public static void main(String[] args){
        System.out.println(jumpFloor(4));
    }

    public static int jumpFloor(int target) {

        if(target <= 0){
            return 0;
        }else if(target == 1 ){
            return 1;
        }else if(target == 2) {
            return 2;
        }
        else {
            return jumpFloor(target-1)  + jumpFloor(target-2);
        }
    }
}
