package org.example.sort.tree;

import java.util.Comparator;

public class BinaryTree<T> {

    BinaryTreeNode<T> root;

    Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return new BinaryTreeNode<>(value);
        }

        if (comparator.compare(value, current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public void toArray(T[] array) {
        inOrderToArray(root,array,0);
    }

    private int inOrderToArray(BinaryTreeNode<T> current, T[] array, int index) {
        if (current != null) {
            index = inOrderToArray(current.left, array, index);
            array[index++] = current.value;
            index = inOrderToArray(current.right, array, index);
        }
        return index;
    }



}
