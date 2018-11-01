package priv.zzy.explore.medium.c03;

import priv.zzy.Solution;
import priv.zzy.utils.print.ListPrintUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。
 */
public class C03T02 extends Solution {

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> reverseQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        queue.add(root);
        TreeNode t;
        List<Integer> level;
        while (!queue.isEmpty() || !reverseQueue.isEmpty()) {
            level = new ArrayList<>();
            while (!queue.isEmpty()) {
                t = queue.pop();
                level.add(t.val);
                if (t.left != null) {
                    reverseQueue.addFirst(t.left);
                }
                if (t.right != null) {
                    reverseQueue.addFirst(t.right);
                }
            }
            result.add(level);
            level = new ArrayList<>();
            while (!reverseQueue.isEmpty()) {
                t = reverseQueue.pop();
                level.add(t.val);
                if (t.right != null) {
                    queue.addFirst(t.right);
                }
                if (t.left != null) {
                    queue.addFirst(t.left);
                }

            }
            if (!level.isEmpty()) result.add(level);
        }

        return result;
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = zigzagLevelOrder(root);
        ListPrintUtil.print(result);
    }
}
