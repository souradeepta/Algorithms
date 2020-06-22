package com.algorithms.searches;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * Binary search is one of the most popular algorithms
 * This class represents iterative version  {@link BinarySearch}
 * Iterative binary search is likely to have lower constant factors because it doesn't involve the overhead of manipulating the call stack.
 * But in java the recursive version can be optimized by the compiler to this version.
 * <p>
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 *
 * @author Souradeepta Biswas
 * @author Gabriele La Greca : https://github.com/thegabriele97
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SearchAlgorithm
 * @see BinarySearch
 */
public class IterativeBinarySearch implements SearchAlgorithm{

    /**
     * This method implements an iterative version of binary search algorithm
     *
     * @param array a sorted array
     * @param key   the key to search in array
     * @return the index of key in the array or -1 if not found
     */
    @Override
    public <T extends Comparable<T>> int find(T @NotNull [] array, T key){
        return search(array, key, 0, array.length);
    }
    private <T extends Comparable<T>> int search(T @NotNull [] array, T key, int left, int right){
        if(right < left) return -1; //key cannot be found

        while(left <= right){
            int middle = (left + right) >>> 1;
            int compare = key.compareTo(array[middle]);
            if(compare == 0){
                return middle;
            }
            else if (compare < 0){
                right = --middle;
            }
            else {
                left = ++middle;
            }
        }
        return -1;
    }

    //driver code
    public static void main(String[] args) {
        Random number = ThreadLocalRandom.current();
        int size = 100;
        int maxElement = 200;
        Integer[] integers = IntStream.generate(() -> number.nextInt(maxElement)).limit(size).sorted().boxed().toArray(Integer[]::new);

        Integer target = integers[number.nextInt(size - 1)];

        IterativeBinarySearch search = new IterativeBinarySearch();
        int atIndex = search.find(integers, target);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d"
                , target, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, target);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }

}
