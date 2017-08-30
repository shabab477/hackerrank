/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author Shabab
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for(int c = 0; c < n; c++)
        {
            array[c] = sc.nextInt();
        }
        
        int numberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        
        System.out.printf("Array is sorted in %d swaps.\n", numberOfSwaps);
        System.out.printf("First Element: %d\n", array[0]);
        System.out.printf("Last Element: %d\n", array[n - 1]);
        
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
