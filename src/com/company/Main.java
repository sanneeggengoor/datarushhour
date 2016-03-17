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


    public Main(int num){
        puzzlenum = num;
    }

    public void run() {
        
        System.out.println(puzzlenum);

        // create 5 trials (for the 5 grids)
        trial = new Search();
        trial2 = new Search();
        trial3 = new Search();
        trial4 = new Search();
        trial5 = new Search();

        Games game= new Games();

        //
        trial.addNode(game.getGame(1));
        trial2.addNode(game.getGame(2));
        trial3.addNode(game.getGame(3));
        trial4.addNode(game.getGame(4));
        trial5.addNode(game.getGame(5));


        trial.findSolution();
        trial2.findSolution();
        trial3.findSolution();
        trial4.findSolution();
        // the greatest grid gave an out of memory error after half an hour
        // trial5.findSolution();



    }
}
