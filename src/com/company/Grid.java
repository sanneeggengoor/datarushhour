package com.company;

/**
 * Created hoihoi
 */
public class Grid {

    private int rows;
    private int columns;
    private int[][] grid;


    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        grid = new int[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                grid[i][j] = 0;
            }
        }
    }

    public int[][] getGrid(){
        return grid;
    }

    public void printGrid(){
        for (int i = 0; i< rows; i++){
            System.out.println(grid[i]);
        }
    }
}
