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
    private static final int MAXCAR = 25;

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

    public void printPath() {
        Grid pathGrid = this.getPrevious();
        if (previous != null) {

            pathGrid.printPath();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
            System.out.print("steps: ");
            System.out.println(this.getCount());
            this.printGrid();


    }

    }

    public Grid getPrevious(){
        return previous;
    }

    public Grid makeFirstGrid(){
        Grid grid = new Grid(6,6);
        Car car = new Car(true,2,3,2,1);
        Car car2 = new Car(false, 4, 0, 2, 2);
        Car car3 = new Car(true, 4, 1, 2, 3);
        Car car4 = new Car(false,3,3, 3,4);
        Car car5 = new Car(false,0,2,3,5);
        Car car6 = new Car(true, 0,3,2,6);
        Car car7 = new Car(false, 0, 5, 3, 7);
        Car car8 = new Car(true, 3, 4, 2, 8);
        Car car9 = new Car(true, 5, 4, 2, 9);
        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car7);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car4);
        grid.addCar(car8);
        grid.addCar(car9);
        grid.printGrid();

        return grid;
    }

    public Grid makeSecGrid(){
        Grid grid = new Grid(6, 6);
        Car car = new Car(true, 2, 2, 2, 1);
        Car car2 = new Car(false, 4, 0, 2, 2);
        Car car3 = new Car(true, 3, 0, 2, 3);
        Car car4 = new Car(true, 0, 2, 2,4);
        Car car5 = new Car(true, 1, 1, 2, 5);
        Car car6 = new Car(true, 1, 3, 2, 6);
        Car car7 = new Car(true, 3, 2, 2, 7);
        Car car8 = new Car(false, 4, 3, 2, 8);
        Car car9 = new Car(true, 5, 4, 2, 9);
        Car car10 = new Car(true, 4, 4, 2, 10);
        Car car11 = new Car(false, 2, 4, 2, 11);
        Car car12 = new Car(false, 1, 5, 3, 12);
        Car car13 = new Car(true, 0, 4, 2, 13);
        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car7);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car4);
        grid.addCar(car8);
        grid.addCar(car9);
        grid.addCar(car10);
        grid.addCar(car11);
        grid.addCar(car12);
        grid.addCar(car13);
        System.out.println("2");
        grid.printGrid();

        return grid;
    }

    public Grid makeThirdGrid(){
        Grid grid = new Grid(6,6);
        Car car = new Car(true,2,0,2,1);
        Car car2 = new Car(false, 4, 0, 2, 2);
        Car car3 = new Car(true, 3, 0, 2, 3);
        Car car4 = new Car(false,2,2, 2,4);
        Car car5 = new Car(true,1,1,2,5);
        Car car6 = new Car(true, 0,1,2,6);
        Car car7 = new Car(true, 0, 3, 3, 7);
        Car car8 = new Car(false, 1, 3, 2, 8);
        Car car9 = new Car(true, 1, 4, 2, 9);
        Car car10 = new Car(false, 2, 5, 2, 10);
        Car car11 = new Car(true, 4, 4, 2, 11);
        Car car12 = new Car(true, 3, 3, 2, 12);
        Car car13 = new Car(false, 4, 2, 2, 13);

        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car7);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car4);
        grid.addCar(car8);
        grid.addCar(car9);
        grid.addCar(car10);
        grid.addCar(car11);
        grid.addCar(car12);
        grid.addCar(car13);
        grid.printGrid();

        return grid;
    }

    public Grid makeFourthGrid(){

        Grid grid = new Grid(9,9);
        Car car = new Car(true,4,1,2,1);
        Car car2 = new Car(false, 7, 0, 2, 2);
        Car car3 = new Car(true, 6, 0, 2, 3);
        Car car4 = new Car(false,4,0, 2,4);
        Car car5 = new Car(true,3,0,2,5);
        Car car6 = new Car(false, 0,0,2,6);
        Car car7 = new Car(true, 0, 1, 3, 7);
        Car car8 = new Car(false, 1, 3, 3, 8);
        Car car9 = new Car(false, 4, 3, 2, 9);
        Car car10 = new Car(false, 6, 3, 2, 10);
        Car car11 = new Car(true, 8, 1, 3, 11);
        Car car12 = new Car(false, 7, 4, 2, 12);
        Car car13 = new Car(true, 6, 4, 2, 13);
        Car car14 = new Car(true, 5, 5, 3, 14);
        Car car15 = new Car(true, 3, 5, 3, 15);
        Car car16 = new Car(false, 0, 5, 3, 16);
        Car car17 = new Car(true, 1, 6, 3, 17);
        Car car18 = new Car(false, 2, 8, 3, 18);
        Car car19 = new Car(false, 5, 8, 3, 19);
        Car car20 = new Car(true, 8, 7, 2, 20);
        Car car21 = new Car(true, 8, 5, 2, 21);

        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car7);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car4);
        grid.addCar(car8);
        grid.addCar(car9);
        grid.addCar(car10);
        grid.addCar(car11);
        grid.addCar(car12);
        grid.addCar(car13);
        grid.addCar(car14);
        grid.addCar(car15);
        grid.addCar(car16);
        grid.addCar(car17);
        grid.addCar(car18);
        grid.addCar(car19);
        grid.addCar(car20);
        grid.addCar(car21);
        grid.printGrid();

        return grid;
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
        gridnew.count = this.count;
        gridnew.path = this.path;
        setGrid(gridnew);
        return gridnew;


    }

    public String getPath(){
        return path;
    }

    public void addPath(String move){
        this.path = this.path + move;
    }

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

    /** Prints the grid by looping through the grid and printing the value with spaces
     * and a new line when at the end of a row. */
    public void printGrid(){
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < columns; j++){
                if(grid[i][j] != 0 && grid[i][j]<10) {
                    System.out.print(grid[i][j]);
                    System.out.print(" ");
                } else if (grid[i][j] != 0){
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print("  ");
                }
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
