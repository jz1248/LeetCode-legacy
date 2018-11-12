package priv.zzy.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a general tree node.
 * @param <T>
 */
public class TreeNode<T> {
    private final int MAX_CHILD_NUMBER = Integer.MAX_VALUE;

    protected T value;
    protected int numberOfChild;
    protected List<TreeNode<T>> children;
    protected TreeNode<T> parent;

    public TreeNode(T value, int numberOfChild) {
        this(value, numberOfChild, true);
    }

    protected TreeNode(T value, int numberOfChild, boolean initField) {
        if (numberOfChild < 0 || numberOfChild > MAX_CHILD_NUMBER)
            throw new IllegalArgumentException("Illegal number of child: " + numberOfChild);
        this.value = value;
        this.numberOfChild = numberOfChild;
        if (initField) {
            children = new ArrayList<>(numberOfChild);
            for (int i = 0; i < numberOfChild; i++) {
                children.add(null);
            }
        }
    }

    protected void setChild(TreeNode<T> node, int index) {
        this.children.set(index, node);
    }

    protected TreeNode<T> getChild(int index) {
        return this.children.get(index);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
