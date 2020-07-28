package com.wanted.onepeople.leetcode;


/**
 * 功能描述：
 *
 * @author xiyouquedongxing
 * @Date 2020-06-12
 */
public class NumberOfIslands {

    public static void main(String[] args){
        char[][] grid = { {'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        NumberOfIslands test = new NumberOfIslands();
        System.out.println(test.numIslands(grid));
    }

    public int numIslands(char[][] grid){
        int isLandNums = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    //把上下左右相邻的1都改成2，后续遍历就不会重复
                    infect(grid, i, j);
                    isLandNums++;
                }
            }
        }
        return isLandNums;
    }
    //感染函数
    public void infect(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }

}
