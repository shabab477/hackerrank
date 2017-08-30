/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author Shabab
 */



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HeapMedian {
    
    public static int left(int index)
    {
        return index * 2;
    }
    
    public static int right(int index)
    {
        return index * 2 + 1;
    }
    
    public static int parent(int index)
    {
        return index / 2;
    }
    
    public static void add(int[] array, int lastIndex, int num)
    {
        array[lastIndex] = num;
        heapify(array, lastIndex);
    }
    
    public static void heapify(int[] array, int lastIndex)
    {
        int parentIndex = parent(lastIndex);
        if(parentIndex >= 1)
        {
            if(array[lastIndex] > array[parentIndex])
            {
                int temp = array[lastIndex];
                array[lastIndex] = array[parentIndex];
                array[parentIndex] = temp;
                heapify(array, parentIndex);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n * 2 + 10];
        int size = 0;
        
        for(int c= 0; c < n; c++){
            int num = in.nextInt();
            add(array, size + 1, num);
            size++;
            
            if(size % 2 == 1)
            {
                System.out.println(array[size / 2]);
            }
            else
            {
                System.out.println((array[size / 2] + array[(size / 2) - 1]) / 2);
            }
        }
    }
}

