package com.algorithms.sorts;

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
                if(less(array[j], array[j+1])){
                    swap(array, array[j], array[j+1]);
                    swapped = true;

                }
            }
            if(!swapped) {
                break;

            }
        }
        return array;
    }
}
