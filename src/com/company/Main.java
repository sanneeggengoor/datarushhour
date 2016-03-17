package com.company;



public class Main {

    public static void main(String[] args) {
        //parse args
        for (int i = 1; i<5; i++) {
            int puzzlenum = i;
            new Main(puzzlenum).run();
        }
    }
    private int puzzlenum;
    public Search trial;

    public Main(int num){
        puzzlenum = num;
    }

    public void run() {
        System.out.println(puzzlenum);

        // create a trial, add first grid and search for solution
        trial = new Search();
        Games game= new Games();
        trial.addNode(game.getGame(puzzlenum));
        trial.findSolution();
    }
}
