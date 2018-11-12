package priv.zzy.common;

/**
 * Definition for a binary tree node.
 */
public class BinaryTreeNode<T> extends TreeNode<T> {

    public BinaryTreeNode(T value) {
        super(value, 2);
    }

    public BinaryTreeNode<T> getLeft() {
        return (BinaryTreeNode<T>)getChild(0);
    }

    public void setLeft(BinaryTreeNode<T> node) {
        setChild(node, 0);
    }

    public BinaryTreeNode<T> getRight() {
        return (BinaryTreeNode<T>)getChild(1);
    }

    public void setRight(BinaryTreeNode<T> node) {
        setChild(node, 1);
    }
}
