package com.company;

public class Main {

    public static void main(String[] args) {
        //parse args
        int puzzlenum = 1;
        new Main(puzzlenum).run();
    }

    private int puzzlenum;

    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        Grid grid = new Grid(6,6);
        //grid.printGrid();
        Car car = new Car(true,2,3,2,1);
        Car car2 = new Car(false, 1, 1, 3, 2);
        grid.addCar(car);
        grid.addCar(car2);
        grid.printGrid();
        Grid newGrid = grid.moveCarPlus(car,grid);
        System.out.println("hello");
        newGrid.printGrid();
        Grid newGrid2 = newGrid.moveCarMin(car2,newGrid);
        System.out.println("hello again");
        newGrid2.printGrid();
    }



}
