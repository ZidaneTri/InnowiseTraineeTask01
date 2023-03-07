package org.example.sort.parallel;

import java.util.Comparator;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickTask<T> extends RecursiveAction {

    T[] array;
    Comparator<T> comparator;
    int begin;
    int end;

    public ParallelQuickTask(T[] array, int begin, int end, Comparator<T> comparator) {
        this.array = array;
        this.comparator = comparator;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end, comparator);
            invokeAll(new ParallelQuickTask<>(array, begin, pivotIndex-1, comparator), new ParallelQuickTask<>(array, pivotIndex+1, end, comparator));
        }
    }

    private int partition(T[] array, int begin, int end, Comparator<T> comparator) {
        T pivot = array[end];
        int i = begin-1;

        for(int j = begin; j < end; j++) {
            if(comparator.compare(array[j], pivot) <= 0){
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, end);
        return i;
    }

    private void swap(T[] array, int i1, int i2) {
        T swapObj = array[i1];
        array[i1] = array[i2];
        array[i2] = swapObj;
    }

}
