package org.example.sort;

import java.util.Comparator;

public class OddEvenSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator){
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 1; i < array.length -1; i += 2) {
                if (comparator.compare(array[i], array[i+1]) > 0) {
                    swap(array, i, i+1);
                    sorted = false;
                }
            }
            for(int i = 0; i < array.length - 1; i += 2) {
                if (comparator.compare(array[i], array[i+1]) > 0) {
                    swap(array, i, i+1);
                    sorted = false;
                }
            }
        }
    }

    private<T> void swap(T[] array, int i1, int i2) {
        T swapObj = array[i1];
        array[i1] = array[i2];
        array[i2] = swapObj;
    }
}
