package com.company;

/**
 * Class that makes all the starting grids
 */
public class Games {

    // the class contains all grids
    private Grid grid1;
    private Grid grid2;
    private Grid grid3;
    private Grid grid4;
    private Grid grid5;

    // a game has every grid in it's object
    public Games(){
        grid1 = makeFirstGrid();
        grid2 = makeSecGrid();
        grid3 = makeThirdGrid();
        grid4 = makeFourthGrid();
        grid5 = makeAdvancedGrid();
    }

    // gives back a certain game, depending on the integer id
    public Grid getGame(int id){
        switch (id){
            case 1:
                return grid1;
            case 2:
                return grid2;
            case 3:
                return grid3;
            case 4:
                return grid4;
            default:
                return grid5;
        }
    }

    // create the first grid
    private Grid makeFirstGrid(){

        // create a grid
        Grid grid = new Grid(6,6);

        // create all cars
        Car car = new Car(true,2,3,2,1);
        Car car2 = new Car(false, 4, 0, 2, 2);
        Car car3 = new Car(true, 4, 1, 2, 3);
        Car car4 = new Car(false,3,3, 3,4);
        Car car5 = new Car(false,0,2,3,5);
        Car car6 = new Car(true, 0,3,2,6);
        Car car7 = new Car(false, 0, 5, 3, 7);
        Car car8 = new Car(true, 3, 4, 2, 8);
        Car car9 = new Car(true, 5, 4, 2, 9);

        // add all cars
        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car7);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car4);
        grid.addCar(car8);
        grid.addCar(car9);

        // print the grid
        grid.printGrid();

        // return the grid
        return grid;
    }

    // creates second grid (works the same way as makeFirstGrid())
    private Grid makeSecGrid(){
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

    // creates third grid (works same way as makeFirstGrid())
    private Grid makeThirdGrid(){
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

    // creates fourth grid (works same way as makeFirstGrid())
    private Grid makeFourthGrid(){

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

    // creates the advanced grid (works same way as makeFirstGrid())
    private Grid makeAdvancedGrid(){

        Grid grid = new Grid(12,12);
        Car car = new Car(true,5,2,2,1);
        Car car2 = new Car(true,11, 1, 2, 2);
        Car car3 = new Car(false, 8, 2, 2, 3);
        Car car4 = new Car(true,8,0, 2,4);
        Car car5 = new Car(true,7,0,3,5);
        Car car6 = new Car(true, 6,0,3,6);
        Car car7 = new Car(false, 3, 0, 3, 7);
        Car car8 = new Car(false, 3, 1, 3, 8);
        Car car9 = new Car(true, 2, 0, 3, 9);
        Car car10 = new Car(false, 0, 0, 2, 10);
        Car car11 = new Car(true, 2, 3, 2, 11);
        Car car12 = new Car(true, 4, 2, 3, 12);
        Car car13 = new Car(false, 5, 4, 2, 13);
        Car car14 = new Car(false, 6, 3, 2, 14);
        Car car15 = new Car(true, 7, 4, 2, 15);
        Car car16 = new Car(true, 8, 3, 3, 16);
        Car car17 = new Car(true, 9, 3, 3, 17);
        Car car18 = new Car(true, 11, 3, 3, 18);
        Car car19 = new Car(false, 9,6, 3, 19);
        Car car20 = new Car(false, 6,6, 3  , 20);
        Car car21 = new Car(false, 5, 5, 2, 21);
        Car car22 = new Car(false, 3, 5, 2, 22);
        Car car23 = new Car(false, 1, 5, 2, 23);
        Car car24 = new Car(false, 0, 6, 2, 24);
        Car car25 = new Car(false, 2, 6, 3, 25);
        Car car26 = new Car(true, 0,7, 3, 26);
        Car car27 = new Car(true, 2,7, 2, 27);
        Car car28 = new Car(true, 3,7, 2, 28);
        Car car29 = new Car(true, 4, 7, 3, 29);
        Car car30 = new Car(false, 6,7, 2, 30);
        Car car31 = new Car(true, 8,7, 3, 31);
        Car car32 = new Car(true, 9,8, 2, 32);
        Car car33 = new Car(false, 10,9, 2, 33);
        Car car34 = new Car(true, 11, 7, 2, 34);
        Car car35 = new Car(false, 9, 10, 3, 35);
        Car car36 = new Car(false, 10,11, 2, 36);
        Car car37 = new Car(false, 8, 11, 2, 37);
        Car car38 = new Car(true, 7, 10, 2, 38);
        Car car39 = new Car(true, 6, 10, 2, 39);
        Car car40 = new Car(false, 6,9, 2, 40);
        Car car41 = new Car(true, 3, 9, 2, 41);
        Car car42 = new Car(false, 1, 10,2, 42);
        Car car43 = new Car(false, 1, 11,2, 43);
        Car car44 = new Car(true, 0, 10, 2, 44);

        grid.addCar(car);
        grid.addCar(car2);
        grid.addCar(car3);
        grid.addCar(car4);
        grid.addCar(car5);
        grid.addCar(car6);
        grid.addCar(car7);
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
        grid.addCar(car22);
        grid.addCar(car23);
        grid.addCar(car24);
        grid.addCar(car25);
        grid.addCar(car26);
        grid.addCar(car27);
        grid.addCar(car28);
        grid.addCar(car29);
        grid.addCar(car30);
        grid.addCar(car31);
        grid.addCar(car32);
        grid.addCar(car33);
        grid.addCar(car34);
        grid.addCar(car35);
        grid.addCar(car36);
        grid.addCar(car37);
        grid.addCar(car38);
        grid.addCar(car39);
        grid.addCar(car40);
        grid.addCar(car41);
        grid.addCar(car42);
        grid.addCar(car43);
        grid.addCar(car44);
        grid.printGrid();

        return grid;

    }
}
