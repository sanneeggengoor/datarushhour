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
    public Search trial4;


    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        trial = new Search();
        trial2 = new Search();
        trial3 = new Search();
        trial4 = new Search();
        Grid grid = new Grid(6,6);

        //trial.addNode(grid.makeFirstGrid());
        //trial.findSolution();
        trial2.addNode(grid.makeSecGrid());
        trial3.addNode(grid.makeThirdGrid());
        trial4.addNode(grid.makeFourthGrid());


        //trial2.findSolution();
        trial4.findSolution();
/**
        long timeTrial1Before = System.nanoTime();
        while (true){
            if (trial.checkIfOK()){
                break;
            }

            trial.makeAllChildren();
        }
        long timeTrial1After = System.nanoTime();

        Grid good = trial.getNode();
        System.out.println(good.getPath());
        System.out.println(good.getCount());
        good.printGrid();
        good.printPath();
        long time1 = (timeTrial1After - timeTrial1Before)/1000000;
        System.out.println("Path: "+good.getPath());
        System.out.println("Number of necessary steps: " + Integer.toString(good.getCount()));
        System.out.println("Time (in milliseconds): " + Long.toString(time1));


        long timeTrial2Before = System.nanoTime();
        while (true){
            if (trial2.checkIfOK()){
                break;
            }

            trial2.makeAllChildren();
        }
        long timeTrial2After = System.nanoTime();
        Grid good2 = trial2.getNode();
        System.out.println(good2.getPath());
        System.out.println(good2.getCount());
        good2.printGrid();
        good2.printPath();
        long time2 = (timeTrial2After - timeTrial2Before)/1000000;
        System.out.println("Path: "+good2.getPath());
        System.out.println("Number of necessary steps: " + Integer.toString(good2.getCount()));
        System.out.println("Time (in milliseconds): " + Long.toString(time2));
 */

    }

}
