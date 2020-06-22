package com.algorithms.sorts;

/**
 * The class contains util methods
 *
 * @author Souradeepta Biswas
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 **/
public final class SortUtils {

    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param idx   index of the first element
     * @param idy   index of the second element
     */
    static <T> boolean swap(T[]array, int idx, int idy){
        T temp = array[idx];
        array[idx] = array[idy];
        array[idy] = temp;
        return true;
    }
}
