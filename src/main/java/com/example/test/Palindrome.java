package com.example.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args){
//        isPalindrome(12321);
//        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(2);
//        l1.next.next.next = new ListNode(7);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next.next.next = new ListNode(2);
//        l1.next.next.next.next.next.next.next.next = new ListNode(0);
//        l1.next.next.next.next.next.next.next.next.next = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        l2.next = new ListNode(0);
//        l2.next.next = new ListNode(1);
//        l2.next.next.next = new ListNode(7);
//        l2.next.next.next.next = new ListNode(5);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(2);
//        l2.next.next.next.next.next.next.next = new ListNode(7);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        ListNode result = addTwoNumber(l1,l2);
//        System.out.println(result);


//        System.out.println(shortestPalindrome("cabbaf"));
        int[] a = {2,4,3,5,7,4,9};
        lengthOfLIS(a);
    }

    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next =  mergeTwoLists(l1.next,l2);
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
        }

        return l1;
    }

    static class ListNode{
        int val;
        Palindrome.ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }


    public ListNode cycleList(ListNode listNode){
        if(listNode==null || listNode.next == null){
            return null;
        }
        ListNode slow = listNode;
        ListNode fast = listNode;
        while ((fast.next!= null && fast.next.next!= null)){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast.next==null || fast.next.next==null){
            return null;
        }
        slow= listNode;
        while (slow!= fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static ListNode addTwoNumber(ListNode l1,ListNode l2){
        Queue<Integer> stackList1 = new LinkedList<>() ;
        Queue<Integer> stackList2 = new LinkedList<>();
        while (l1!=null){
            stackList1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!= null){
            stackList2.add(l2.val);
            l2 = l2.next;
        }
        Queue<Integer> resultStack = new LinkedList<>();
        int c=0;
        while ((!stackList1.isEmpty()) || (!stackList2.isEmpty())){
            Integer temp = (stackList1.isEmpty()?0:stackList1.remove())+(stackList2.isEmpty()?0:stackList2.remove())+c;
            c=0;
            if(temp>=10){
                temp= temp%10;
                c=1;
            }
            resultStack.add(temp);
        }
        if(c==1){
            resultStack.add(1);
        }
        if(resultStack.isEmpty()){
            return null;
        }
        ListNode result = new ListNode(resultStack.remove()) ;
        ListNode res= result;
        while(!resultStack.isEmpty()){
            ListNode t = new ListNode(resultStack.remove());
            res.next = t;
            res=res.next;
        }
        return result;
    }


    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.charAt(i);
        }
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public static String shortestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = java.lang.Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        //这里的话需要修改
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            int start = (i - P[i]) / 2;
            //我们要判断当前回文串是不是开头是不是从 0 开始的
            if (start == 0) {
                maxLen = P[i] > maxLen ? P[i] : maxLen;
            }
        }
        return new StringBuilder(s.substring(maxLen)).reverse() + s;
    }


    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

//    public int reverse(Integer n){
//        String s = String.valueOf(n);
//        Stack<Character> characterStack = new Stack<>();
//        for (char c:s.toCharArray()
//             ) {
//            characterStack.push(c);
//        }
//        char[] result = new char[s.length()];
//        while (!characterStack.isEmpty()){
//
//        }
//    }




}

