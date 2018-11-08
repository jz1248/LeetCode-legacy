package priv.zzy.explore.medium.c07;

import priv.zzy.Solution;
import priv.zzy.common.BinaryTreeNode;
import priv.zzy.utils.BinaryTreeUtil;

/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     int val;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 *     BinaryTreeNode(int x) { val = x; }
 * }
 */

/**
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串
 * 并且将这个字符串反序列化为原始的树结构。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，
 * 你的序列化和反序列化算法应该是无状态的。
 */
public class C07T01 extends Solution {

    // Encodes a tree to a single string.
    public String serialize(BinaryTreeNode root) {
        return doSerialize(root);
    }

    private String doSerialize(BinaryTreeNode root) {
        if (root == null) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(root.val);
        sb.append(doSerialize(root.left));
        sb.append(doSerialize(root.right));
        sb.append(']');

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.equals("[]")) return null;

        if (data.charAt(0) == '[') data = data.substring(1);
        if (data.charAt(data.length() - 1) == ']') data = data.substring(0, data.length() - 1);

        return doDeserialize(data);
    }

    private BinaryTreeNode doDeserialize(String data) {
        if (data == null || data.equals("")) return null;
        int leftTreeBegin = data.indexOf('[');
        int leftTreeEnd = pairingIndex(data, leftTreeBegin);

        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(data.substring(0, leftTreeBegin)));
        node.left = doDeserialize(data.substring(leftTreeBegin + 1, leftTreeEnd));
        node.right = doDeserialize(data.substring(leftTreeEnd + 2, data.length() - 1));

        return node;
    }

    private int pairingIndex(String s, int index) {
        int flag = 1;
        int nextLeft = s.indexOf('[', index + 1);
        int nextRight = s.indexOf(']', index + 1);
        while (flag > 0) {
            if (nextLeft < nextRight) {
                ++flag;
                nextLeft = s.indexOf('[', nextLeft + 1);
            } else {
                --flag;
                if (flag == 0) {
                    return nextRight;
                }
                nextRight = s.indexOf(']', nextRight + 1);
            }
        }

        return -1;
    }

    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left  = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);

        String serializedTree = serialize(root);
        System.out.println("Tree serialized as: " + serializedTree);

        BinaryTreeNode newTree = deserialize(serializedTree);
    }
}
