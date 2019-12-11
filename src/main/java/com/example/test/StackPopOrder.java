package com.example.test;

import java.util.Stack;

public class StackPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> push = new Stack<>();
        int i=0;
        for (int pushInt:pushA){
            push.push(pushInt);
            if(pushInt== popA[i]){
                push.pop();
                i++;
            }
        }
        while (!push.isEmpty() && i<popA.length){
            if(push.peek() != popA[i]){
                return false;
            }else {
                push.pop();
                i++;
            }

        }
        return true;
    }
}
