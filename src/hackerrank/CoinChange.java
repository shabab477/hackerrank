/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;

import java.util.Scanner;

/**
 *
 * @author Shabab
 */
public class CoinChange {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        
        
        System.out.println(coinChange(coins, n));
    }
    
    public static long coinChange(int[] coins, int money)
    {
        long memory[][] = new long[coins.length + 1][money + 1];
        for(int c = 0; c < memory.length; c++)
        {
            memory[c][0] = 1;
        }
        
        for(int c = 1; c < memory.length; c++)
        {
            for(int i = 1; i <= money; i++)
            {
                if(i >= coins[c - 1])
                {
                    memory[c][i] = memory[c - 1][i] + memory[c][i - coins[c -1 ]];
                }
                else
                {
                    memory[c][i] = memory[c - 1][i];
                }
                
            }
        }
        
        
        return memory[coins.length][money];
    }
}
