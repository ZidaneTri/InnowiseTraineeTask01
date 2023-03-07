package org.example.sort.parallel;

import org.example.sort.Sort;

import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;

public class ParallelQuickSort implements Sort {
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.invoke(new ParallelQuickTask<>(array,0, array.length-1, comparator));
    }
}
