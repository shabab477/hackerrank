/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.BitSet;
import java.util.Scanner;

/**
 *
 * @author Shabab
 */
public class BitManipulation {
    
    static double number = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        BitSet set = new BitSet(101);
        for(int c = 0; c < tc; c++)
        {
            int n = sc.nextInt();
            set.flip(n);
        }
        
        System.out.println(set.nextSetBit(0));
        
    }
    
    
    
}
