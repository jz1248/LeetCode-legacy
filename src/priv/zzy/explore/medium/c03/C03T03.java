package priv.zzy.explore.medium.c03;

import priv.zzy.Solution;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class C03T03 extends Solution {

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int indexOf(int[] array, int val) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode treeNode = new TreeNode(preorder[0]);
        int rootIndex = indexOf(inorder, preorder[0]);
        if (rootIndex > 0) {
            // build left tree
            treeNode.left = buildTree(
                    Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                    Arrays.copyOfRange(inorder, 0, rootIndex)
            );
        }
        if (rootIndex < inorder.length - 1) {
            // build right tree
            treeNode.right = buildTree(
                    Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length)
            );
        }
        return treeNode;
    }

    @Override
    public void run() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = buildTree(preorder, inorder);
    }
}
