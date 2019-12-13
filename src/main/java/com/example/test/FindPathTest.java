package com.example.test;

import java.util.ArrayList;

public class FindPathTest {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.right.left = new TreeNode(8);
        root1.right.left.left = new TreeNode(2);
        FindPathTest findPathTest = new FindPathTest();
        ArrayList<ArrayList<Integer>> re = findPathTest.FindPath(root1,25);
        System.out.println(re);
    }



    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> n = new ArrayList<>();
        FindPath(root,target,n);
        return result;
    }

    public void FindPath(TreeNode root, int target,ArrayList<Integer> list){
        if(root.left == null && root.right == null){
            if(root.val == target){
                list.add(root.val);
                result.add(list);
            }
        }else {
            list.add(root.val);
            if(root.left != null){
                FindPath(root.left,target-root.val,list);
            }
            if(root.right != null){
                FindPath(root.right,target-root.val,list);
            }
        }
    }

}
