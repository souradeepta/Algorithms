package com.algorithms.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.algorithms.sorts.SortUtils.less;
import static com.algorithms.sorts.SortUtils.print;

/**
 * @author Souradeepta Biswas
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 */
public class InsertionSort implements SortAlgorithm {

    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     *
     * @param array The array to be sorted
     **/
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {

            // Picking up the key
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && (less(key, array[j]))) {
                array[j + 1] = array[j];
                j--;
            }
            // Placing the key at its correct position in the sorted subarray
            array[j + 1] = key;
        }
        return array;
    }

    // driver program
    public static void main(String[] args) {
        //generate data
        Random number = ThreadLocalRandom.current();
        int size = 1000;
        int maxElement = 200;

        Integer[] integers = IntStream.generate(() -> number.nextInt(maxElement)).limit(size).boxed().toArray(Integer[]::new);

        InsertionSort insertionSort = new InsertionSort();

        long startTime = System.nanoTime();
        insertionSort.sort(integers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.

        System.out.printf("Sorted integer array of size %d is: %s%n found in: %d ms\n", integers.length, Arrays.toString(integers), duration);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        print(insertionSort.sort(strings));
    }

}

