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

    public Grid gridCopy() {
        Grid gridnew = new Grid(rows, columns);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                gridnew.grid[i][j] = this.grid[i][j];
            }
        }
        return gridnew;
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
    }

    public Grid moveCarPlus(Car car, Grid gridold){
        Grid gridnew = gridold.gridCopy();
        if(car.getDirection()){
            int newY = car.getY() + car.getLength();
            if(newY < gridold.getRows() && gridnew.grid[car.getX()][newY]==0){
                gridnew.grid[car.getX()][car.getY()] = 0;
                gridnew.grid[car.getX()][newY] = car.getId();
                car.setY(car.getY()+1);
            }
        } else {
            int newX = car.getX() + car.getLength();
            if(newX < gridold.getColumns() && gridnew.grid[newX][car.getY()]==0){
                gridnew.grid[car.getX()][car.getY()] = 0;
                gridnew.grid[newX][car.getY()] = car.getId();
                car.setX(car.getX()+1);
            }
        }
        return gridnew;
    }

    public Grid moveCarMin(Car car, Grid gridold){
        Grid gridnew = gridold.gridCopy();
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
}
