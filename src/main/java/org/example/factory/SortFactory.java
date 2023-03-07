package org.example.factory;

import org.example.sort.*;
import org.example.sort.parallel.ParallelMergeSort;
import org.example.sort.parallel.ParallelQuickSort;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class SortFactory {
    static Map<String, Supplier<Sort>> factoryMap =
            Map.of("mergesort",  MergeSort::new,
                    "quicksort",  QuickSort::new,
                    "heapsort",  HeapSort::new,
                    "treesort",  TreeSort::new,
                    "oddevensort",  OddEvenSort::new,
                    "parallelmergesort",  ParallelMergeSort::new,
                    "parallelquicksort",  ParallelQuickSort::new
            );

    public static Sort createSort(String action) {
        action = action.toLowerCase(Locale.ROOT);
        Supplier<Sort> factory = factoryMap.get(action);
        if (factory == null) {
            throw new IllegalArgumentException();
        }
        return factory.get();
    }
}


