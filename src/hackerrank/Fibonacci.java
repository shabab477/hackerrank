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
public class Fibonacci {
    
    public static int fibonacci(int n) {
        if(n == 1)
            return 1;
        else if(n  == 0)
            return 0;
        return fibonacci(n - 1) + fibonacci(n - 2);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
    
}
