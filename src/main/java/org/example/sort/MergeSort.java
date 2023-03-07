package org.example.sort;

import java.util.Arrays;
import java.util.Comparator;


public class MergeSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator){
        mergeSort(array,comparator);
    }


    private static <T> void mergeSort(T[] array, Comparator<T> comparator){

        if (array.length < 2)
            return;

        int middle = array.length / 2;
        T[] leftArray = Arrays.copyOfRange(array,0, middle);
        T[] rightArray = Arrays.copyOfRange(array, middle, array.length);
        mergeSort(leftArray,comparator);
        mergeSort(rightArray,comparator);

        merge(array,leftArray,rightArray,comparator);
    }

    private static <T> void merge(T[] array, T[] leftArray, T[] rightArray, Comparator<T> comparator){

        int main = 0;
        int left = 0;
        int right = 0;


        while (left < leftArray.length && right < rightArray.length){
            if(comparator.compare(leftArray[left], (rightArray[right])) < 0){
                array[main++] = leftArray[left++];
            } else{
                array[main++] = rightArray[right++];
            }
        }
        while(left < leftArray.length){
            array[main++] = leftArray[left++];
        }
        while(right < rightArray.length){
            array[main++] = rightArray[right++];
        }
    }
}
