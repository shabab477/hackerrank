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
public class Primes {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            String msg = isPrime(n) ? "Prime" : "Not prime";
            System.out.println(msg);
            
        }
    }
    
    static boolean isPrime(int n)
    {
        if (n == 1) 
            return false;
        int limit = (int)Math.sqrt(n);
        for(int c = 2; c <= limit; c++)
        {
            if(n % c == 0)
                return false;
        }
        
        return true;
    }
}
