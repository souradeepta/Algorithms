package com.algorithms.searches;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

/**
 *
 *
 *
 * Binary search is one of the most popular algorithms
 * The algorithm finds the position of a target value within a sorted array
 *
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	    O(log n)
 * Worst-case space complexity	O(1)
 *
 * @author Souradeepta Biswas
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SearchAlgorithm
 * @see IterativeBinarySearch
 *
 */
public class BinarySearch implements SearchAlgorithm{
    /**
     *
     * @param array is an array where the element should be found
     * @param key is an element which should be found
     * @param <T> is any comparable type
     * @return index of the element
     */
    @Override
    public <T extends Comparable<T>> int find(T @NotNull [] array, T key){
        return search(array, key, 0 , array.length);
    }

    /**
     * This method implements the Generic Binary Search
     *
     * @param array The array to make the binary search
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The  upper bound
     * @return the location of the key
     **/
    private <T extends Comparable<T>> int search(T @NotNull [] array, T key, int left, int right){
        if(right < left) return -1; //key cannot be found

        //find middle
        int middle = (left + right) >>> 1;
        int compare = key.compareTo(array[middle]);

        if(compare == 0){
            return middle;
        }
        else if (compare < 0){
            return search(array, key, left, middle -1);
        }
        else {
            return search(array, key, middle + 1, right);
        }
    }

    //driver code
    public static void main(String[] args){
        //generate sample data
        Random number = ThreadLocalRandom.current();
        int size = 100;
        int maxElement = 200;
        Integer[] integers = IntStream.generate(() -> number.nextInt(maxElement)).limit(size).sorted().boxed().toArray(Integer[]::new);


        Integer target = integers[number.nextInt(size -1)];
        BinarySearch search = new BinarySearch();
        int atIndex = search.find(integers, target);

        System.out.println(String.format("Target to be found: %d at index %d of array length %d", target, atIndex, size));

        int toCheck = Arrays.binarySearch(integers, target);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));

    }
}
