package com.company;



public class Main {

    public static void main(String[] args) {
        //parse args
        int puzzlenum = 1;
        new Main(puzzlenum).run();
    }
    private int puzzlenum;
    public Search trial;


    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        trial = new Search();
        Grid grid = new Grid(6,6);
        Car car = new Car(true,2,3,2,1);
        Car car2 = new Car(false, 4, 0, 2, 2);
        Car car3 = new Car(true, 4, 1, 2, 3);
        Car car7 = new Car(false,3,3, 3,7);
        Car car5 = new Car(false,0,2,3,5);
        Car car6 = new Car(true, 0,3,2,6);
        Car car4 = new Car(false, 0, 5, 3, 4);
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

        trial.addNode(grid);



        while (true){
            if (trial.checkIfOK()){
                break;
            }

            trial.makeAllChildren();
            //System.out.println("Kids gemaakt");
        }

        Grid good = trial.getNode();
        System.out.println("hoi");
        System.out.println(good.getPath());
        System.out.println(good.getCount());
        good.printGrid();
        while(true){
            good = good.getPrevious();
            if (good == null){
                break;
            }
            System.out.println(good.getCount());
            good.printGrid();

        }

    }

}
