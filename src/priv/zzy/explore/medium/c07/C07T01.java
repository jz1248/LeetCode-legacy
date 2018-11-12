package priv.zzy.explore.medium.c07;

import priv.zzy.Solution;
import priv.zzy.common.BinaryTreeNode;
import priv.zzy.common.Deserializer;
import priv.zzy.utils.deserializers.IntegerDeserializer;
import priv.zzy.utils.tree.BinaryTreeDeserializer;
import priv.zzy.utils.tree.BinaryTreeSerializer;

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
    public String serialize(BinaryTreeNode<Integer> root) {
        return (new BinaryTreeSerializer<Integer>()).serialize(root);
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode<Integer> deserialize(String data) {
        Deserializer<Integer> deserializer = new IntegerDeserializer();
        return (new BinaryTreeDeserializer<>(deserializer)).deserialize(data);
    }

    @Override
    public void run() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeft(new BinaryTreeNode<>(2));
        root.setRight(new BinaryTreeNode<>(3));
        root.getRight().setLeft(new BinaryTreeNode<>(4));
        root.getRight().setRight(new BinaryTreeNode<>(5));

        String serializedTree = serialize(root);
        System.out.println("Tree serialized as: " + serializedTree);

        BinaryTreeNode newTree = deserialize(serializedTree);

    }

}