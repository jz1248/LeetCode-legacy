package priv.zzy.utils;

import priv.zzy.common.BinaryTreeNode;

public class BinaryTreeUtil {

    /**
     * 计算二叉树高度
     * @param root
     * @return
     */
    public static int height(BinaryTreeNode root) {
        if (root == null) return 0;
        return Integer.max(height(root.left), height(root.right)) + 1;
    }
}
