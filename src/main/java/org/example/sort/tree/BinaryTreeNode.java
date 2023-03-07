package org.example.sort.tree;

class BinaryTreeNode<T> {

    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T value)
    {
        this.value = value;
        left = null;
        right = null;
    }
}
