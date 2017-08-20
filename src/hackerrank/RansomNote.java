/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 14101138
 */
public class RansomNote {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        /**************************************************/
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String str : magazine)
        {
            if(!map.containsKey(str))
            {
                map.put(str, new Integer(0));
            }
            
            map.put(str, map.get(str) + 1);
        }
        
        boolean flag = true;
        
        for(String str : ransom)
        {
            if(!map.containsKey(str) || map.get(str) <= 0)
            {
                flag = false;
                break;
            }
            
            map.put(str, map.get(str) - 1);
        }
        
        if(flag)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
    
}

