package org.example.sort;

import org.example.sort.tree.BinaryTree;

import java.util.Comparator;

public class TreeSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        BinaryTree<T> sortTree = new BinaryTree<>(comparator);
        for (T t : array) {
            sortTree.insert(t);
        }
        sortTree.toArray(array);
    }
}
