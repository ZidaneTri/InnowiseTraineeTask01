package org.example.sort;

import java.util.Comparator;

public class HeapSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        heapify(array, comparator);
        int end = array.length - 1;
        while (end > 0) {
            swap(array,end,0);
            end--;
            siftDown(array,0,end,comparator);
        }
    }

    private <T> void heapify(T[] array, Comparator<T> comparator) {
        for (int start = (array.length-2) / 2; start >= 0; start--){
            siftDown(array, start, array.length-1, comparator);
        }
    }

    private <T> void siftDown(T[] array, int start, int end, Comparator<T> comparator) {
        int root = start;
        while ((2 * root + 1) <= end){
            int child = 2 * root + 1;
            int swap = root;
            if (comparator.compare(array[swap], array[child] ) < 0) {
                swap = child;
            }
            if (((child + 1) <= end) && (comparator.compare(array[swap], array[child+1] ) < 0)){
                swap = child + 1;
            }
            if(swap == root){
                return;
            } else {
                swap(array,root,swap);
                root = swap;
            }
        }
    }

    private<T> void swap(T[] array, int i1, int i2) {
        T swapObj = array[i1];
        array[i1] = array[i2];
        array[i2] = swapObj;
    }
}
