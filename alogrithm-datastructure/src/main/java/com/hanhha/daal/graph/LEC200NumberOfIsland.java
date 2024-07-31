package com.hanhha.daal.graph;

//https://leetcode.com/problems/number-of-islands/
public class LEC200NumberOfIsland {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[][] grid;

    public boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1';
    }

    public void dfs(int x, int y, int n, int m) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            System.out.printf(
                    """
                    - i = %d
                        (*) [x,y] =[%d,%d]
                        (*) newX = %d + dx[%d] = %s
                        (*) newY = %d + dy[%d] = %s
                        (*) => grid[%s][%s]
                        (*) isValid = %s
                    """,
                    i, x, y, x, i, newX, y, i, newY, newX, newY, isValid(newX, newY, n, m)
            );
            if (isValid(newX, newY, n, m)) {
                dfs(newX, newY, n, m);
            }
        }
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    System.out.printf("========= init I = %d, J = %d ===========\n", i, j);
                    dfs(i, j, n, m);
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
         */
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        LEC200NumberOfIsland lec200NumberOfIsland = new LEC200NumberOfIsland();
        int result = lec200NumberOfIsland.numIslands(grid);
        System.out.println(result);
    }

}
