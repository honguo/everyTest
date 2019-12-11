//package com.example.test;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//public class RebuildTreeTest {
//
//
//    private RebuildTree rebuildTree;
//
//    public RebuildTreeTest(RebuildTree rebuildTree){
//        this.rebuildTree = rebuildTree;
//    }
//
//    @Test
//    public void rebuildBinaryTree() {
//        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
//        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
//        TreeNode treeNode = rebuildTree.rebuildBinaryTree(preorder, inorder);
//        System.out.println(treeNode);
//
//    }
//}