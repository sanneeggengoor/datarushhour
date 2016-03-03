package com.company;

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid(6,6);
        //grid.printGrid();
        Car car = new Car(true,2,2,3,1);
        grid.addCar(car);
        grid.printGrid();
    }
}
