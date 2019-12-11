package com.example.test;

import java.util.Stack;

public class MinStack {

    private static Stack<Integer> stack = new Stack<>();

    private static Stack<Integer> min = new Stack<>();

    public static void main(String[] args){
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());

    }

    public static void push(int node) {
        stack.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else {
            if(node < min.peek()){
                min.push(node);
            }else {
                Stack<Integer> temp = new Stack<>();
                while ((!min.isEmpty()) && min.peek()<node){
                    temp.push(min.pop());
                }
                min.push(node);
                while (!temp.isEmpty()){
                    min.push(temp.pop());
                }
            }
        }
    }

    public static void pop() {
        if(stack.pop().equals(min.peek())){
            min.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int min() {
        return min.peek();
    }
}
