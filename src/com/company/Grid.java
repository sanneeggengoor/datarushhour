package com.company;


/**
 * Class for grid objects. In a grid a current state is saved. It contains a number of rows and columns, a
 * two-dimensional array with a representation of the current position of the cars and an array with all
 * the cars and their position.
 * In this class grids can be copied and printed. Also cars can be added to and moved on the grid, these
 * methods return a new grid. The elements from the grid (rows, columns, grid and cars) can also be retrieved
 * in other classes, by asking getRows() etc. Last, there is a method that checks if two grids have the same
 * grid[][] and there is a method that makes a string out of the grid.
 *
 */
public class Grid {

    private int rows;
    private int columns;
    private int[][] grid;
    private Car[] cars;

    /** Creates new Grid with rows rows and columns columns*/
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

    /** Returns a copy of a grid, by creating a new grid and copying the information in a loop */
    public Grid gridCopy() {
        Grid gridnew = new Grid(rows, columns);
        gridnew.rows = this.rows;
        gridnew.columns = this.columns;
        /* Copies the grid */
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                gridnew.grid[i][j] = this.grid[i][j];
            }
        }
        /* Copies the carlist */
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

    /** Prints the grid by looping through the grid and printing the value with spaces
     * and a new line when at the end of a row. */
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

    /** Adds a new car to the grid, by adding the value of id to the places where the
     * car is present in the grid. Also the car is added to the carlist of the Grid.
     */
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

    /** Moves car one down or to the right (depending on the direction of the car) by
     * removing one from the front of the car and adding one to the end of the car.
     * Also the coordinates of the car in the car are changed and the changed car
     * is added to the carlist in the grid.
     */
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

    /** Moves car one up or to the left, works the same way as moveCarPlus.
     */
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

    /** Checks if the grid of two Grids are equal by looping through the array with
     * the grid.
     */
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

    /** Converts Grid into a string with all values of the grid. Useful as key in hashtable */
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
