package com.algorithms.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.algorithms.sorts.SortUtils.less;
import static com.algorithms.sorts.SortUtils.swap;
/**
 * @author Souradeepta Biswas
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */
public class SelectionSort implements SortAlgorithm{

    /**
     * This method implements the Generic Selection Sort
     *
     * @param array The array to be sorted
     *            Sorts the array in increasing order
     **/
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array){
        int size = array.length;
        for(int i =0; i < size - 1; i++){
            int minIndex = i;
            for(int j = i+1; j< size; j++){
                if(less(array[j], array[minIndex])){
                    minIndex = j;
                }
            }
            // Swapping if index of min is changed
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
        return array;
    }

    // driver program
    public static void main(String[] args) {

        //generate sample data
        Random number = ThreadLocalRandom.current();
        int size = 100;
        int maxElement = 200;
        Integer[] integers = IntStream.generate(()->number.nextInt(maxElement)).limit(size).boxed().toArray(Integer[]::new);

        SelectionSort selectionSort = new SelectionSort();

        selectionSort.sort(integers);

        System.out.printf("Sorted integer array is: %s%n", Arrays.toString(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
