package com.company;



public class Main {

    public static void main(String[] args) {
        //parse args
        int puzzlenum = 1;
        new Main(puzzlenum).run();
    }
    private int puzzlenum;
    public Search trial;
    public Search trial2;
    public Search trial3;


    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        trial = new Search();
        trial2 = new Search();
        trial3 = new Search();
        Grid grid = new Grid(6,6);

        trial.addNode(grid.makeFirstGrid());
        trial2.addNode(grid.makeSecGrid());
        trial3.addNode(grid.makeThirdGrid());


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
