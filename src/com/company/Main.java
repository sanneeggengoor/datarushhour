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


    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        trial = new Search();
        trial2 = new Search();
        Grid grid = new Grid(6,6);

        Grid grid1 = grid.makeFirstGrid();
        System.out.println("1");
        grid1.printGrid();
        System.out.println("1");

        trial.addNode(grid1);
        trial2.addNode(grid.makeSecGrid());


        while (true){
            if (trial.checkIfOK()){
                break;
            }

            trial.makeAllChildren();
        }

        Grid good = trial.getNode();
        System.out.println(good.getPath());
        System.out.println(good.getCount());
        good.printGrid();
        good.printPath();

        while (true){
            if (trial2.checkIfOK()){
                break;
            }

            trial2.makeAllChildren();
        }
        Grid good2 = trial2.getNode();

    }

}
