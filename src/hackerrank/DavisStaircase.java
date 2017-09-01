/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Shabab
 */
public class DavisStaircase {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            
            HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
            
            System.out.println(goGoRecursion(n, memory));
        }
    }

    private static int goGoRecursion(int n, HashMap<Integer, Integer> memory) {
        
        if(n < 0)
        {
            return 0;
        }
        if(n == 0)
        {
            return 1;
        }
        
        if(memory.containsKey(n))
            return memory.get(n);
        
        int total = goGoRecursion(n - 1, memory) + goGoRecursion(n - 2, memory) + goGoRecursion(n -3, memory);
        memory.put(n, total);
        return total;
        
    }
    
}
