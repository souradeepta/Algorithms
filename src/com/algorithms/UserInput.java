package com.algorithms;

import java.util.Scanner;

public class UserInput {
    public static void UserInput(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers do you want ot enter?");
        int size = input.nextInt();

        int[] inputArray = new int[size];

        System.out.println("Enter the " + size + " numbers now.");

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = input.nextInt();
        }

        System.out.println("Input array is: ");
        printArray(inputArray);
        input.close();
    }

    public static void printArray(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
