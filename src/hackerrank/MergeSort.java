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

//1 5 2 1 3 1 2
//1 5 1 1 1 2 2 
//1 5 2 1 3 1 2
public class MergeSort {
    static long counter = 0;
    
    static long countInversions(int array[]) {
        counter = 0;
        mergeSort(array, 0, array.length - 1);
        return counter;
    }
    
    static void mergeSort(int[] array, int left, int right)
    {
        if(left >= right)
            return;
        
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    
    static void merge(int array[], int left, int mid, int right)
    {
        int tempLeft[] = new int[mid - left + 2];
        int tempRight[] = new int[right - (mid + 1) + 2];
        
        tempLeft[mid - left + 1] = Integer.MAX_VALUE;
        tempRight[right - (mid + 1) + 1] = Integer.MAX_VALUE;
        
        for(int c = 0, i = left; i <= mid; i++, c++)
        {
            tempLeft[c] = array[i];
        }
       
        
        for(int c = 0, i = mid + 1; i <= right; i++, c++)
        {
            tempRight[c] = array[i];
        }
        
        int globalIndex = left;
        int tlp = 0;
        int rlp = 0;
        while(globalIndex <= right)
        {
            
            if(tempLeft[tlp] <= tempRight[rlp])
            {
                array[globalIndex] = tempLeft[tlp];
                tlp++;
                
                
            }
            else 
            {
                array[globalIndex] = tempRight[rlp];
                rlp++;
                counter += (mid - (tlp + left) + 1);
            }
            
            globalIndex++;
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
            //System.out.println(Arrays.toString(arr));
            
        }
        in.close();
    }
}
