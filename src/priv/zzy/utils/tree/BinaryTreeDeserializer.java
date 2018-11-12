package priv.zzy.utils.tree;

import priv.zzy.common.BinaryTreeNode;
import priv.zzy.common.Deserializer;

import java.io.Serializable;

public class BinaryTreeDeserializer<T extends Serializable> {

    static final String SUBTREE_SPLITTER_BEGIN = BinaryTreeSerializer.SUBTREE_SPLITTER_BEGIN;
    static final String SUBTREE_SPLITTER_END = BinaryTreeSerializer.SUBTREE_SPLITTER_END;

    private static final String ESCAPING_CHARACTER = "\\";

    private Deserializer<T> deserializer;

    public BinaryTreeDeserializer(Deserializer<T> deserializer) {
        this.deserializer = deserializer;
    }

    public BinaryTreeNode<T> deserialize(String data) {

        if (data == null || data.equals("")) return null;

        try {
            return doDeserialize(data);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Error while deserializing binary tree data: " + data
                    + "\nPlease check syntax.");
        } catch (Exception e) {
            System.err.println("Error while deserializing binary tree data: " + data);
            e.printStackTrace();
        }

        return null;
    }

    private BinaryTreeNode<T> doDeserialize(String data) {
        if (data == null || data.equals("")) return null;
        int leftTreeBegin = data.indexOf('[');
        int leftTreeEnd = pairingIndex(data, leftTreeBegin);

        T value = deserializer.deserialize(data.substring(0, leftTreeBegin));
        BinaryTreeNode<T> node = new BinaryTreeNode<>(value);
        node.setLeft(doDeserialize(data.substring(leftTreeBegin + 1, leftTreeEnd)));
        node.setRight(doDeserialize(data.substring(leftTreeEnd + 2, data.length() - 1)));

        return node;
    }

    // pairing subtree splitter
    private int pairingIndex(String s, int index) {
        int flag = 1;
        int nextLeft = s.indexOf(SUBTREE_SPLITTER_BEGIN, index + 1);
        int nextRight = s.indexOf(SUBTREE_SPLITTER_END, index + 1);
        while (flag > 0) {
            if (nextLeft < nextRight) {
                ++flag;
                nextLeft = s.indexOf(SUBTREE_SPLITTER_BEGIN, nextLeft + 1);
            } else {
                --flag;
                if (flag == 0) {
                    return nextRight;
                }
                nextRight = s.indexOf(SUBTREE_SPLITTER_END, nextRight + 1);
            }
        }

        return -1;
    }
}
