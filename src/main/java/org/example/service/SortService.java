package org.example.service;

import org.example.factory.SortFactory;
import org.example.sort.Sort;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortService<T> {

    private Sort sorter;
    private Comparator<T> comparator;

    private static final Logger LOGGER = Logger.getLogger(SortService.class.getName());

    public SortService() {
        this.setDefault();
    }

    public SortService(Sort sorter, Comparator<T> comparator) {
        this.sorter = sorter;
        this.comparator = comparator;
    }

    public void setSorter(Sort sorter) {
        this.sorter = sorter;
    }

    public void setSorter(String sorter) {
        try {
            this.sorter = SortFactory.createSort(sorter);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Requested sorter cannot be provided, retreating to default sorter");
            this.sorter = SortFactory.createSort("mergesort");
        }

    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    public void setDefault() {
        this.sorter = SortFactory.createSort("mergesort");
        this.comparator = Comparator.comparing(o -> o.getClass().getSimpleName());
    }

    public void reverseComparator() {
        this.comparator = comparator.reversed();
    }

    public void sort(T[] array) {
        sorter.sort(array, this.comparator);
    }

    @Override
    public String toString() {
        return "SortService now use" +
                "sorter=" + sorter.getClass().getSimpleName() +
                ", comparator=" + comparator +
                '}';
    }
}
