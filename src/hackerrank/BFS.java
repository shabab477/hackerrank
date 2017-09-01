/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Shabab
 */
public class BFS {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int tc = 0; tc < t; tc++)
        {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int c = 0; c < nodes; c++)
            {
                list.add(new ArrayList<Integer>());
            }
            
            for(int c = 0; c < edges; c++)
            {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                list.get(from).add(to);
                list.get(to).add(from);
            }
            
            int startIndex  = sc.nextInt() - 1;
            
            int[] cost = bfs(list, startIndex);
            //System.out.println(Arrays.toString(cost));
            for(int c = 0; c < cost.length; c++)
            {
                if(startIndex != c)
                {
                    if(cost[c] == 0)
                        System.out.print(-1 + " ");
                    else
                        System.out.print(cost[c] + " ");
                }
            }
            System.out.println();
        }
    }
    
    static int[] bfs(ArrayList<ArrayList<Integer>> list, int start)
    {
        int[] cost = new int[list.size()];
        Arrays.fill(cost, 0);
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        
        while(!q.isEmpty())
        {
            int index = q.remove();
            for(int c = 0; c < list.get(index).size(); c++)
            {
                if(cost[list.get(index).get(c)] == 0 && list.get(index).get(c) != start)
                {
                    cost[list.get(index).get(c)] = cost[index] + 6;
                    q.add(list.get(index).get(c));
                }
            }
        }
        
        return cost;
    }
    
}
