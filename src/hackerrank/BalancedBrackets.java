/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 14101138
 */
public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<String>();
        for(int c = 0; c < expression.length(); c++)
        {
            String ch = String.valueOf(expression.charAt(c));
            if(isOpening(ch))
            {
                stack.add(ch);
            }
            else
            {
                String cor = getCorrespondingBracket(ch);
                if(!stack.isEmpty())
                {
                    if(cor.equals(stack.peek()))
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static boolean isOpening(String br)
    {
        return br.equals("(") || br.equals("[") || br.equals("{");
    }
    
    
    public static String getCorrespondingBracket(String close)
    {
        if(close.equals("}"))
        {
            return "{";
        }
        else if(close.equals("]"))
        {
            return "[";
        }
        else
        {
            return "(";
        }
            
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
