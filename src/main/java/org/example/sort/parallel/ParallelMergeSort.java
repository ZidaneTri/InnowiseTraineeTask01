package org.example.sort.parallel;

import org.example.sort.Sort;

import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort implements Sort {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.invoke(new ParallelMergeTask<>(array, comparator));
    }
}
