package com.example.test;

import org.junit.Test;

public class LinkListCURDTest {

    @Test
    public void addHead() {
        LinkListCURD singleList = new LinkListCURD();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }
}