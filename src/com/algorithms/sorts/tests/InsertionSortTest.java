package com.algorithms.sorts.tests;

import com.algorithms.sorts.InsertionSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    private InsertionSort suite;

    @BeforeEach
    public void setUp() throws Exception {
        suite = new InsertionSort();
    }


    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shouldDoNothingWithEmptyArray() {
        Integer[] values = {};
        suite.sort(values);
    }

    @Test
    public void shouldDoNothingWithOneElementArray() {
        Integer[] values = {42};
        suite.sort(values);
        Assertions.assertArrayEquals(new Integer[]{42}, values);
    }

    @Test
    public void shouldSortValues() {
        Integer[] values = {9, -3, 5, 0, 1};
        Integer[] expectedOrder = {-3, 0, 1, 5, 9};
        suite.sort(values);
        Assertions.assertArrayEquals(expectedOrder, values);
    }

}
