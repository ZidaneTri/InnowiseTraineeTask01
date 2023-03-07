package org.example.sort;

import java.util.Comparator;

public class QuickSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        quickSort(array,0, array.length-1, comparator);
    }

    private <T> void quickSort(T[] array, int begin, int end, Comparator<T> comparator) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end, comparator);

            quickSort(array, begin, pivotIndex-1, comparator);
            quickSort(array, pivotIndex+1, end, comparator);
        }
    }

    private <T> int partition(T[] array, int begin, int end, Comparator<T> comparator) {
        T pivot = array[end];
        int i = begin-1;

        for(int j = begin; j < end; j++) {
            if(comparator.compare(array[j], pivot) <= 0){
                i++;
                swap(array,i,j);
            }
        }
        i++;
        swap(array, i, end);
        return i;
    }

    private <T> void swap(T[] array, int i1, int i2) {
        T swapObj = array[i1];
        array[i1] = array[i2];
        array[i2] = swapObj;
    }
}
