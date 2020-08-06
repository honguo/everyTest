package com.example.test;

//import com.yeepay.g3.utils.common.encrypt.AES;

/**
 * 二叉搜索树转排序双链表
 */
public class TreeInvoke {
    private TreeNode previous;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        if(pRootOfTree.left != null){
            Convert(pRootOfTree.left);
        }
        if(previous != null){
            previous.right = pRootOfTree;
            pRootOfTree.left = previous;
        }
        previous = pRootOfTree;
        if(pRootOfTree.right != null){
            Convert(pRootOfTree.right);
        }
        return pRootOfTree;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode( 6);
        root1.right = new TreeNode(14);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(8);
        root1.right.left = new TreeNode(12);
        root1.right.right = new TreeNode(16);
        TreeInvoke treeInvoke = new TreeInvoke();
        treeInvoke.Convert(root1);

    }


}
