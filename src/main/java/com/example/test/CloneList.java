package com.example.test;

public class CloneList {

    public static void main(String[] args){
        CloneList c = new CloneList();
        RandomListNode pHead = new RandomListNode(1);
        pHead.next =new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.next.next.next.next = new RandomListNode(5);
        pHead.random = pHead.next.next;
        pHead.next.random = pHead.next.next.next.next;
        pHead.next.next.next.random = pHead.next;
        RandomListNode node = c.Clone(pHead);
        System.out.println(pHead);
        System.out.println(node);
    }

    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        while (p != null){
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = pHead;
        while (p != null && p.random != null){
            p.next.random = p.random.next;
            p = p.next.next;
        }
        RandomListNode result = pHead.next;
        p = result;
        while (p.next != null && p.next.next != null){
            p.next = p.next.next;
            p = p.next;
        }
        return result;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
