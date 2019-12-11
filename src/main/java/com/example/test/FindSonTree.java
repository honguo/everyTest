package com.example.test;

import java.util.Stack;

public class FindSonTree {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode('#');
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode('#');
        root1.left.right = new TreeNode(9);
        root1.left.right.left = new TreeNode('#');
        root1.left.right.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode('#');
        root2.right = new TreeNode(9);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);
//         TreeNode root1 = new TreeNode(8);
//         root1.left = new TreeNode(8);
//         root1.right = new TreeNode(7);
//         root1.left.left = new TreeNode(9);
//         root1.left.right = new TreeNode(2);
//         root1.left.right.left = new TreeNode(4);
//         root1.left.right.right = new TreeNode(7);
//         TreeNode root2 = new TreeNode(8);
//         root2.left = new TreeNode(9);
//         root2.right = new TreeNode(2);
//        FindSonTree f = new FindSonTree();
        System.out.println(HasSubtree(root1, root2));
    }


    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root1 != null || !stack.isEmpty()){
            while (root1 != null){
                if(sameTree(root1,root2)){
                    return true;
                }else {
                    stack.push(root1);
                    root1 = root1.left;
                }
            }
            root1 = stack.pop().right;
        }
        return false;

    }

    public static boolean sameTree(TreeNode root1,TreeNode root2){
        if((root1 == null && root2 == null) || (root1 != null && root2 == null) ){
            return true;
        }else if(root1 == null ){
            return false;
        }else if (root1.val == root2.val){
            return sameTree(root1.left ,root2.left) && sameTree(root1.right,root2.right);
        }else {
            return false;
        }

    }

    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode mirror = null;
            mirror = root.left;
            root.left = root.right;
            root.right = mirror;
            if (root.left != null){
                Mirror(root.left);
            }
            if(root.right != null){
                Mirror(root.right);
            }
        }

    }

}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.val = val;
    }
}

