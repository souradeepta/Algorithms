package com.algorithms.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.algorithms.sorts.SortUtils.*;

/**
 * @author Souradeepta Biswas
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */
public class BubbleSort implements SortAlgorithm{

    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array){
        int size = array.length;
        boolean swapped;
        for(int i = 0; i < size - 1; i++){
            swapped = false;
            for(int j= 0; j< size - 1- i; j++){
                if(less(array[j+1], array[j])){
                    try{
                        swap(array, j, j+1);
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Swap operation failed");
                    }
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
        return array;
    }
    //driver program
    public static void main(String[] args) {

        //creating sample data
        Random number = ThreadLocalRandom.current();
        int size = 1000;
        int maxElement = 200;

        Integer[] integers = IntStream.generate(()-> number.nextInt(maxElement)).limit(size).boxed().toArray(Integer[]::new);

        BubbleSort bubbleSort = new BubbleSort();

        long startTime = System.nanoTime();
        bubbleSort.sort(integers);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.

        System.out.printf("Sorted integer array of size %d is: %s%n found in: %d ms\n", integers.length, Arrays.toString(integers), duration);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        print(bubbleSort.sort(strings));

    }
}

