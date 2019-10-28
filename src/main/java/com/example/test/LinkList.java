package com.example.test;

import java.util.ArrayList;
import java.util.Stack;

public class LinkList {

    public static void main(String[] args){
        //输入链表，返回链表

        ListNode listNode = null;
        listNode.val=2;
        ListNode temp = null;
        listNode.next= temp;



    }
    public ArrayList<Integer> print(ListNode listnode){
        Stack<Integer> stack = new Stack<Integer>();
        while (listnode!=null) {
            stack.push(listnode.val);

        }
        ArrayList<Integer> list =new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;

    }


    //返回数组
}


     class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

