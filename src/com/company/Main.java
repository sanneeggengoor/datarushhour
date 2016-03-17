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
    public Search trial5;


    public Main(int num) {
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);
        trial = new Search();
        trial2 = new Search();
        trial3 = new Search();
        trial4 = new Search();
        trial5 = new Search();
        Grid grid = new Grid(6,6);

        trial.addNode(grid.makeFirstGrid());
        trial2.addNode(grid.makeSecGrid());
        trial3.addNode(grid.makeThirdGrid());
        trial4.addNode(grid.makeFourthGrid());
        trial5.addNode(grid.makeAdvancedGrid());


        //trial.findSolution();
        //trial2.findSolution();
        //trial3.findSolution();
        //trial4.findSolution();
        trial5.findSolution();



    }
}
