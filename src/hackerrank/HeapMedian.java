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
    }
    
    
    public static void heapifyMax(int[] array, int lastIndex)
    {
        int parentIndex = parent(lastIndex);
        if(parentIndex >= 1)
        {
            if(array[lastIndex] > array[parentIndex])
            {
                int temp = array[lastIndex];
                array[lastIndex] = array[parentIndex];
                array[parentIndex] = temp;
                heapifyMax(array, parentIndex);
            }
        }
    }
    
    public static void heapifyMin(int[] array, int lastIndex)
    {
        int parentIndex = parent(lastIndex);
        if(parentIndex >= 1)
        {
            if(array[lastIndex] < array[parentIndex])
            {
                int temp = array[lastIndex];
                array[lastIndex] = array[parentIndex];
                array[parentIndex] = temp;
                heapifyMin(array, parentIndex);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Float> minPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Float> maxPq = new PriorityQueue<>();
        
        for(int c = 0; c < n; c++)
        {
            float num = in.nextInt();
            if(minPq.size() <= maxPq.size())
            {
                minPq.add(num);
            }
            else
            {
                maxPq.add(num);
            }
            
            if(minPq.size() != 0 && maxPq.size() != 0 && minPq.peek() > maxPq.peek())
            {
                float mn = minPq.remove();
                float mx = maxPq.remove();
                
                maxPq.add(mn);
                minPq.add(mx);
            }
            
            if(maxPq.size() == minPq.size())
            {
                System.out.println(String.format("%.1f", (maxPq.peek() + minPq.peek()) / 2));
            }
            else
            {
                System.out.println(String.format("%.1f",  minPq.peek()));
            
            }
        }
    }
}

