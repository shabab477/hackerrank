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
public class DFS {
    static int counter = 0;
    static int maxVal = -1;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        boolean flag[][] = new boolean[n][m];
        for(int c = 0; c < n; c++)
        {
            for(int i = 0; i < m; i++)
            {
                if(!flag[c][i] && grid[c][i] == 1)
                {
                    counter = 0;
                    dfs(flag, grid, c, i, n, m);
                    maxVal = Math.max(maxVal, counter);
                }
            }
        }
        System.out.println(maxVal);
    }
    
    public static void dfs(boolean[][] flag, int array[][], int posX, int posY, int sizeX, int sizeY)
    {
        if(posX < sizeX && posY < sizeY && posX >= 0 && posY >= 0 && array[posX][posY] == 1 && !flag[posX][posY])
        {
            flag[posX][posY] = true;
            counter++;
            dfs(flag, array, posX + 1, posY, sizeX, sizeY);
            dfs(flag, array, posX - 1, posY, sizeX, sizeY);
            dfs(flag, array, posX, posY + 1, sizeX, sizeY);
            dfs(flag, array, posX, posY - 1, sizeX, sizeY);
            
            dfs(flag, array, posX + 1, posY + 1, sizeX, sizeY);
            dfs(flag, array, posX - 1, posY + 1, sizeX, sizeY);
            dfs(flag, array, posX + 1, posY - 1, sizeX, sizeY);
            dfs(flag, array, posX - 1, posY - 1, sizeX, sizeY);
            
        }
    }
}
