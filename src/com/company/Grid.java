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
        gridnew.rows = this.rows;
        gridnew.columns = this.columns;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                gridnew.grid[i][j] = this.grid[i][j];
            }
        }
        int i = 1;
        while (this.cars[i]!=null){
            Car car = this.cars[i];
            Car newcar = car.copyCar();
            gridnew.cars[i] = newcar;
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
        //int i = 1;
        /*
        while (cars[i]!=null){
            System.out.println(i);
            i++;
        }*/
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
        int id = car.getId();
        Grid gridnew = this.gridCopy();
        Car newcar = gridnew.cars[id];
        if(newcar.getDirection()){
            int newY = newcar.getY() + newcar.getLength();
            if(newY < this.getRows() && gridnew.grid[newcar.getX()][newY]==0){
                gridnew.grid[newcar.getX()][newcar.getY()] = 0;
                gridnew.grid[newcar.getX()][newY] = newcar.getId();
                newcar.setY(newcar.getY()+1);
            }
        } else {
            int newX = newcar.getX() + newcar.getLength();
            if(newX < this.getColumns() && gridnew.grid[newX][newcar.getY()]==0){
                gridnew.grid[newcar.getX()][newcar.getY()] = 0;
                gridnew.grid[newX][newcar.getY()] = newcar.getId();
                newcar.setX(newcar.getX()+1);
            }
        }
        gridnew.cars[id] = newcar;
        return gridnew;
    }
    //moves car one up or to the left
    public Grid moveCarMin(Car car){
        int id = car.getId();
        Grid gridnew = this.gridCopy();
        Car newcar = gridnew.cars[id];
        if(newcar.getDirection()){
            int newY = newcar.getY() - 1;
            if(newY >= 0 && gridnew.grid[newcar.getX()][newY]==0){
                gridnew.grid[newcar.getX()][newcar.getY() + newcar.getLength() - 1] = 0;
                gridnew.grid[newcar.getX()][newY] = newcar.getId();
                newcar.setY(newY);
            }
        } else  {
            int newX = newcar.getX() - 1;
            if(newX >= 0 && gridnew.grid[newX][newcar.getY()]==0){
                gridnew.grid[newcar.getX() + newcar.getLength() - 1][newcar.getY()] = 0;
                gridnew.grid[newX][newcar.getY()] = newcar.getId();
                newcar.setX(newX);
            }
        }

        gridnew.cars[id] = newcar;
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
