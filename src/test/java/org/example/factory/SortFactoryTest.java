package org.example.factory;

import org.example.sort.*;
import org.example.sort.parallel.ParallelMergeSort;
import org.example.sort.parallel.ParallelQuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortFactoryTest {

    @Test
    public void testMergeSortCreation(){
        assertTrue(SortFactory.createSort("mergesort") instanceof MergeSort);
    }

    @Test
    public void testQuickSortCreation(){
        assertTrue(SortFactory.createSort("quicksort") instanceof QuickSort);
    }

    @Test
    public void testHeapSortCreation(){
        assertTrue(SortFactory.createSort("heapsort") instanceof HeapSort);
    }

    @Test
    public void testTreeSortCreation(){
        assertTrue(SortFactory.createSort("treesort") instanceof TreeSort);
    }

    @Test
    public void testOddEvenSortCreation(){
        assertTrue(SortFactory.createSort("oddevensort") instanceof OddEvenSort);
    }

    @Test
    public void testParallelMergeSortCreation(){
        assertTrue(SortFactory.createSort("parallelmergesort") instanceof ParallelMergeSort);
    }

    @Test
    public void testParallelQuickSortCreation(){
        assertTrue(SortFactory.createSort("parallelquicksort") instanceof ParallelQuickSort);
    }

    @Test
    public void testCreationWithDifferentCase(){
        assertTrue(SortFactory.createSort("MergeSort") instanceof MergeSort);
        assertTrue(SortFactory.createSort("HEAPSORT") instanceof HeapSort);
        assertTrue(SortFactory.createSort("pArAlLeLmErGeSoRt") instanceof ParallelMergeSort);
    }

    @Test
    public void testIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> SortFactory.createSort("bogosort"));
    }


}