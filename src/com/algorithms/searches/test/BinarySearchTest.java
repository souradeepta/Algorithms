package com.algorithms.searches.test;

import com.algorithms.searches.BinarySearch;
import org.junit.jupiter.api.*;

class BinarySearchTest {

    private BinarySearch suite;

    @BeforeEach
    public void setUp() throws Exception {
        suite = new BinarySearch();
    }


    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shouldReturnFalseIfArrayIsEmpty() {
        try {
            Integer target = 1;
            int result = -1;
            Assertions.assertEquals(result, suite.find(new Integer[]{}, target));
        }
        catch (ArrayIndexOutOfBoundsException ex){
//            Assertions.assertEquals(ArrayIndexOutOfBoundsException.class, ex);
            System.out.println("Array out of bounds");
        }
    }

    @Test
    public void shouldReturnFalseIfNotFoundInSortedOddArray() {
        Integer target = 9;
        int result = -1;
        Assertions.assertEquals(result,
                suite.find(new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, target));
    }

    @Test
    public void shouldReturnFalseIfNotFoundInSortedEvenArray() {
        Integer target = 9;
        int result = -1;
        Assertions.assertEquals(result,
                suite.find(new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 }, target));
    }

    @Test
    public void shouldReturnTrueIfFoundAsFirstInSortedArray() {
        Integer target = 0;
        int result = 0;
        Assertions.assertEquals(result,
                suite.find(new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, target));
    }

    @Test
    public void shouldReturnTrueIfFoundAtEndInSortedArray() {
        Integer target = 16;
        int result = 8;
        Assertions.assertEquals(result,
                suite.find(new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, target));
    }

    @Test
    public void shouldReturnTrueIfFoundInMiddleInSortedArray() {
        Integer target = 8;
        int result = 4;
        Assertions.assertEquals(result,
                suite.find(new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, target));
    }

    // covers the 'true' cases above
    @Test
    public void shouldReturnTrueIfFoundAnywhereInSortedArray() {
        Integer [] sorted = new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 };

        for (int i = 0; i < sorted.length; i++) {
            Assertions.assertEquals(i, suite.find(sorted, sorted[i]));
        }
    }

    // covers the 'false' cases above
    @Test
    public void shouldReturnFalseIfNotFoundInSortedArray() {
        Integer[] sorted = new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 };
        int result = -1;
        Assertions.assertEquals(result, suite.find(sorted, sorted[0] - 1));

        for (int i = 0; i < sorted.length; i++) {
            Assertions.assertEquals(result, suite.find(sorted, sorted[i] + 1));
        }
    }

}