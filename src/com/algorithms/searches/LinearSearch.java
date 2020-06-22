package com.algorithms.searches;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Linear search is the easiest search algorithm
 * It works with sorted and unsorted arrays (an binary search works only with sorted array)
 * This algorithm just compares all elements of an array to find a value
 * <p>
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity
 *
 * @author Souradeepta Biswas
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see BinarySearch
 * @see SearchAlgorithm
 * TODO: check compareTo vs equals vs "=="
 */
public class LinearSearch implements SearchAlgorithm{

    /**
     * Generic Linear search method
     *
     * @param array List to be searched
     * @param key Key being searched for
     * @return Location of the key
     */
    @Override
    public <T extends Comparable<T>> int find(T @NotNull [] array, T key) {
        for( int i = 0; i< array.length; i++){
            if(array[i].compareTo(key) == 0){
                return i;
            }
        }
        return -1;
    }

    //driver code
    public static void main(String[] args){
        //generate sample data
        Random number = ThreadLocalRandom.current();
        int size = 100;
        int maxElement = 200;
//        Integer[] integers = Stream.generate(() -> number.nextInt(maxElement)).limit(size).toArray(Integer[]::new);
        Integer[] integers = IntStream.generate(() -> number.nextInt(maxElement)).limit(size).sorted().boxed().toArray(Integer[]::new);

        Integer target = integers[number.nextInt(size - 1)];

        LinearSearch search = new LinearSearch();
        int atIndex = search.find(integers, target);

        System.out.println(String.format("Target to be found: %d at index %d of array length %d", target, atIndex, size));

        int toCheck = Arrays.binarySearch(integers, target);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }


}
