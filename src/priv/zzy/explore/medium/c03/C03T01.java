package priv.zzy.explore.medium.c03;

import priv.zzy.Solution;
import priv.zzy.utils.print.ListPrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 中序 遍历。
 */
public class C03T01 extends Solution {

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    void inorderDfs(TreeNode root, List<Integer> seq) {
        if (root.left != null) {
            inorderDfs(root.left, seq);
        }
        seq.add(root.val);
        if (root.right != null) {
            inorderDfs(root.right, seq);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            inorderDfs(root, result);
        }
        return result;
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);
        ListPrintUtil.print(result);
    }
}
