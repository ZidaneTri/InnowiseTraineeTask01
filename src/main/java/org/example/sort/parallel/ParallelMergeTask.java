package org.example.sort.parallel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeTask<T> extends RecursiveAction {

    T[] array;

    Comparator<T> comparator;

    public ParallelMergeTask(T[] array, Comparator<T> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    @Override
    protected void compute(){

        if (array.length < 2)
            return;

        int middle = array.length / 2;
        T[] leftArray = Arrays.copyOfRange(array,0, middle);
        T[] rightArray = Arrays.copyOfRange(array, middle, array.length);
        invokeAll(new ParallelMergeTask<>(leftArray, comparator), new ParallelMergeTask<>(rightArray, comparator));
        merge(array,leftArray,rightArray,comparator);
    }

    private void merge(T[] array, T[] leftArray, T[] rightArray, Comparator<T> comparator){

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
