package com.example.test;

import java.util.List;

public class FindKthToTailTest {

    public static void main(String[] args){
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        a.next = b;
        System.out.println(ReverseList(a).val);

    }

    private static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }

        ListNode a = head;
        ListNode b = head;
        int count = 0;
        while (a != null){
            a = a.next;
            count++;
        }
        if(count<k){
            return null;
        }
        for (int i = 0;i<count-k;i++){
            b=b.next;
        }
        return b;
    }

    private static ListNode ReverseList(ListNode head) {
//        if(head ==  null){
//            return  null;
//        }
//        ListNode result = head;
//        while (result.next != null){
//            result = result.next;
//        }
//        if(result.next == null){
//            return result;
//        }
//        result.next =
//        return result;

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;


    }

    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
}
