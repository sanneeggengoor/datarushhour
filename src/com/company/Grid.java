package com.company;

import java.util.ArrayList;

/**
 * Created hoihoi
 */
public class Grid {

    private int rows;
    private int columns;
    private int[][] grid;
    private Car[] cars;


    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        grid = new int[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                grid[i][j] = 0;
            }
        }
        cars = new Car[20];
    }

    public Grid gridCopy() {
        Grid gridnew = new Grid(rows, columns);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                gridnew.grid[i][j] = this.grid[i][j];
            }
        }
        int i = 1;
        while (this.cars[i]!=null){
            gridnew.cars[i] = this.cars[i];
            i++;
        }
        return gridnew;

    }

    public Car[] getCars(){
        return cars;
    }

    public int[][] getGrid(){
        return grid;
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public void printGrid(){
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(grid[i][j]);
                if (j != columns - 1){
                    System.out.print(" ");
                } else {
                    System.out.println(" ");
                }
            }
        }
        int i = 1;
        while (cars[i]!=null){
            System.out.println(i);
            i++;
        }
    }

    public void addCar(Car car){
        int x = car.getX();
        int y = car.getY();
        int id = car.getId();
        int length = car.getLength();
        if (car.getDirection()){
            for(int i = 0; i< length; i++){
                grid[x][y+i] =  id;
            }
        } else {
            for(int i = 0; i< length; i++){
                grid[x+i][y] = id;
            }
        }
        this.cars[id]=car;
    }
    //moves car one down or to the right
    public Grid moveCarPlus(Car car){
        Grid gridnew = this.gridCopy();
        if(car.getDirection()){
            int newY = car.getY() + car.getLength();
            if(newY < this.getRows() && gridnew.grid[car.getX()][newY]==0){
                gridnew.grid[car.getX()][car.getY()] = 0;
                gridnew.grid[car.getX()][newY] = car.getId();
                car.setY(car.getY()+1);
            }
        } else {
            int newX = car.getX() + car.getLength();
            if(newX < this.getColumns() && gridnew.grid[newX][car.getY()]==0){
                gridnew.grid[car.getX()][car.getY()] = 0;
                gridnew.grid[newX][car.getY()] = car.getId();
                car.setX(car.getX()+1);
            }
        }
        return gridnew;
    }
    //moves car one up or to the left
    public Grid moveCarMin(Car car){
        Grid gridnew = this.gridCopy();
        if(car.getDirection()){
            int newY = car.getY() - 1;
            if(newY >= 0 && gridnew.grid[car.getX()][newY]==0){
                gridnew.grid[car.getX()][car.getY() + car.getLength() - 1] = 0;
                gridnew.grid[car.getX()][newY] = car.getId();
                car.setY(newY);
            }
        } else {
            int newX = car.getX() - 1;
            if(newX >= 0 && gridnew.grid[newX][car.getY()]==0){
                gridnew.grid[car.getX() + car.getLength() - 1][car.getY()] = 0;
                gridnew.grid[newX][car.getY()] = car.getId();
                car.setX(newX);
            }
        }
        return gridnew;
    }

    public boolean equals(Grid grid1){
        int[][] gridtwo = this.getGrid();
        int[][] gridone = grid1.getGrid();
        int rows = this.getRows();
        int columns = this.getColumns();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (gridone[i][j]!=gridtwo[i][j]){
                    return false;
                }
            }
        }
        return true;

    }
    public void makeAllChildren(Grid oldgrid){

    }

    public String toString(){
        String gridstring = "";
        int rows = this.getRows();
        int columns = this.getColumns();
        int[][] grid = this.getGrid();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                gridstring = gridstring + grid[i][j];
            }
        }
        return gridstring;
    }
}
