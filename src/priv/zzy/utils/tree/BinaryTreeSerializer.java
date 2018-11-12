package priv.zzy.utils.tree;

import priv.zzy.common.BinaryTreeNode;

import java.io.Serializable;

public class BinaryTreeSerializer<T extends Serializable> {

    static final String SUBTREE_SPLITTER_BEGIN = "[";
    static final String SUBTREE_SPLITTER_END = "]";

    private static final String ESCAPING_CHARACTER = "\\";

    public String serialize(BinaryTreeNode<T> root) {
        return doSerialize(root);
    }

    private String doSerialize(BinaryTreeNode<T> root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();

        sb.append(root.getValue());
        sb.append(SUBTREE_SPLITTER_BEGIN);
        sb.append(doSerialize(root.getLeft()));
//        sb.append(StringUtil.encode(
//                doSerialize(root.getLeft()),
//                ESCAPING_CHARACTER,
//                SUBTREE_SPLITTER_BEGIN, SUBTREE_SPLITTER_END
//        ));
        sb.append(SUBTREE_SPLITTER_END);

        sb.append(SUBTREE_SPLITTER_BEGIN);
        sb.append(doSerialize(root.getRight()));
//        sb.append(StringUtil.encode(
//                doSerialize(root.getRight()),
//                ESCAPING_CHARACTER,
//                SUBTREE_SPLITTER_BEGIN, SUBTREE_SPLITTER_END
//        ));
        sb.append(SUBTREE_SPLITTER_END);

        return sb.toString();
    }


}
