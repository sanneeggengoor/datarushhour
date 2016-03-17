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

    // maximum number of cars in a grid
    private static final int MAXCAR = 50;

    // all values stored in the grid
    private int rows;
    private int columns;
    private int[][] grid;
    private Car[] cars;
    private Grid previous;
    private String path;
    private int count;

    // Creates new Grid with rows rows and columns columns
    public Grid(int rows, int columns){
        // give rows and columns correct values
        this.rows = rows;
        this.columns = columns;

        // create new carlist and initiate counter and path
        cars = new Car[MAXCAR];
        this.path = "";
        this.count = 0;

        // create new grid[][] with a given number of rows and columns
        grid = new int[rows][columns];

        // fill the grid with zeroes
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                grid[i][j] = 0;
            }
        }
    }

    // animates the path from the beginning to the solution, by recursively looping through
    // all the states in the path
    public void printPath() {
        // get the Grid which was the parent to the current grid
        Grid pathGrid = this.getPrevious();

        // if this parent isn't the first grid, continue
        if (previous != null) {

            // print all the ancestors of the current grid
            pathGrid.printPath();

            // take a pause of 200 milliseconds, so every grid can be seen
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("exception");
            }

            // print the current step
            System.out.println("step: " + Integer.toString(this.getCount()));

            // print the grid
            this.printGrid();
        }
    }

    public Grid getPrevious(){
        return previous;
    }


    // Returns a copy of a grid, by creating a new grid and copying the information in a loop
    public Grid gridCopy() {

        // create a grid, wherein the previous grid can be copied
        Grid gridnew = new Grid(rows, columns);

        // Copies the grid by looping through the grid
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                gridnew.grid[i][j] = this.grid[i][j];
            }
        }

        // initiate counter for looping through cars
        int i = 1;

        // loop through all cars in list for copying
        while (this.cars[i]!=null){
            Car car = this.cars[i];
            Car newCar = car.copyCar();
            gridnew.cars[i] = newCar;
            i++;
        }

        // copy values for count and path
        gridnew.count = this.count;
        gridnew.path = this.path;

        // link parent to child
        setGrid(gridnew);

        // return the new grid
        return gridnew;
    }

    public String getPath(){
        return path;
    }

    // add move to pathstring
    public void addPath(String move){
        this.path = this.path + move;
    }

    // link parent of current grid to "grid"
    private void setGrid(Grid grid){
        grid.previous = this;
    }

    public int getCount(){
        return count;
    }

    public void addCount(){
        count++;
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

    // Prints the grid by looping through the grid and printing the value with spaces
    // and a new line when at the end of a row.
    public void printGrid(){

        // loop through all positions on the grid by looping through rows and columns
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < columns; j++){

                if (grid[i][j] == 0){
                    System.out.print("  ");
                } else if(grid[i][j]<10) {
                    System.out.print(grid[i][j]);
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j]);
                }
                if (j != columns - 1){
                    System.out.print(" ");
                } else {
                    System.out.println(" ");
                }
            }
        }
    }

    // Adds a new car to the grid, by adding the value of id to the places where the
    // car is present in the grid. Also the car is added to the carlist of the Grid.
    public void addCar(Car car){

        // get all values of the car
        int x = car.getX();
        int y = car.getY();
        int id = car.getId();
        int length = car.getLength();

        // if the car is horizontal, add the car to the grid at (x,y) till (x,y+length)
        // if the car is vertical, add the car to the grid at (x,y) till (x+length, y)
        if (car.getDirection()){
            for(int i = 0; i< length; i++){
                grid[x][y+i] =  id;
            }
        } else {
            for(int i = 0; i< length; i++){
                grid[x+i][y] = id;
            }
        }

        // add car to carlist in grid
        this.cars[id]=car;
    }

    // Moves car one down or to the right (depending on the direction of the car) by
    // removing one from the front of the car and adding one to the end of the car.
    // Also the coordinates of the car in the car are changed and the changed car
    // is added to the carlist in the grid.
    public Grid moveCarPlus(Car car){

        // get id of the car and copy the grid and car
        int id = car.getId();
        Grid gridnew = this.gridCopy();
        Car newcar = gridnew.cars[id];

        // if the car is horizontal, compute a new y
        if(newcar.getDirection()){
            int newY = newcar.getY() + newcar.getLength();

            // if this y is not bigger than the grid and there is not yet a car in this
            // position, move the car by removing the front and adding to the back
            if(newY < this.getRows() && gridnew.grid[newcar.getX()][newY]==0){
                gridnew.grid[newcar.getX()][newcar.getY()] = 0;
                gridnew.grid[newcar.getX()][newY] = newcar.getId();
                newcar.setY(newcar.getY()+1);
            }

        // if the car is vertical, compute a new x
        } else {
            int newX = newcar.getX() + newcar.getLength();

            // if this x is not bigger than the grid and there is not yet a car in this
            // position, move the car by removing the front and adding to the back
            if(newX < this.getColumns() && gridnew.grid[newX][newcar.getY()]==0){
                gridnew.grid[newcar.getX()][newcar.getY()] = 0;
                gridnew.grid[newX][newcar.getY()] = newcar.getId();
                newcar.setX(newcar.getX()+1);
            }
        }

        // add this car to the carlist of the grid and return the grid
        gridnew.cars[id] = newcar;
        return gridnew;
    }

    // Moves car one up or to the left, works the same way as moveCarPlus.
    public Grid moveCarMin(Car car){

        // get id of the car and copy grid and car
        int id = car.getId();
        Grid gridnew = this.gridCopy();
        Car newcar = gridnew.cars[id];

        // if the car is horizontal, compute a new y
        if(newcar.getDirection()){
            int newY = newcar.getY() - 1;

            // if this y isn't smaller than 0 and the position isn't filled yet, move car
            // by removing back and adding one to the front
            if(newY >= 0 && gridnew.grid[newcar.getX()][newY]==0){
                gridnew.grid[newcar.getX()][newcar.getY() + newcar.getLength() - 1] = 0;
                gridnew.grid[newcar.getX()][newY] = newcar.getId();
                newcar.setY(newY);
            }

        // if the car is vertical, compute a new x
        } else  {
            int newX = newcar.getX() - 1;

            // if this x isn't smaller than 0 and the position isn't filled yet, move
            // car by removing back and adding one to the front
            if(newX >= 0 && gridnew.grid[newX][newcar.getY()]==0){
                gridnew.grid[newcar.getX() + newcar.getLength() - 1][newcar.getY()] = 0;
                gridnew.grid[newX][newcar.getY()] = newcar.getId();
                newcar.setX(newX);
            }
        }

        // add car to carlist of the new grid and return the new grid
        gridnew.cars[id] = newcar;
        return gridnew;
    }

    // Checks if the grid of two Grids are equal by looping through the array with the grid.
    // There's no need to check if both grids have the same size, because they all have the
    // same ancestors.
    public boolean equals(Grid grid1){

        // get both grids and the rows and columns
        int[][] gridtwo = this.getGrid();
        int[][] gridone = grid1.getGrid();
        int rows = this.getRows();
        int columns = this.getColumns();

        // loop through the grid and check if each position has the same value
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (gridone[i][j]!=gridtwo[i][j]){
                    return false;
                }
            }
        }
        return true;

    }

    // Converts Grid into a string with all values of the grid. Useful as key in hashSet
    public String toString(){

        // initiate gridstring
        String gridstring = "";

        // retrieve all information of the grid and the grid itself
        int rows = this.getRows();
        int columns = this.getColumns();
        int[][] grid = this.getGrid();

        // loop through the grid and add every value to the gridstring
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                gridstring = gridstring + grid[i][j];
            }
        }

        // return the gridstring
        return gridstring;
    }
}
