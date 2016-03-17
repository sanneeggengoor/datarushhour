package com.company;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Class for searching breadthfirst through a rush hour game for the best solution.
 * For the search a LinkedList is used because then the first element can easily
 * be removed and the elements can easily be added at the back of the list. This is
 * what is needed for the breadth first search.
 */

public class Search {
    // the search class has a HashTable with all the grids and a LinkedList queu for searching
    HashSet<String> stateList;
    LinkedList<Grid> breadthFirst;

    public Search() {
        stateList = new HashSet<>();
        breadthFirst = new LinkedList<>();
    }

    // checks if a state has already been used while searching
    public boolean checkIfOK() {
        // peeks into the upperstate of the search list
        LinkedList<Grid> node = getSearchList();
        Grid grid = node.peek();

        // gets the list with all the cars
        Car[] cars = grid.getCars();

        // gets the position of the 1 car (the red one)
        Car car = cars[1];
        int y = car.getY();

        // if the 1 car has y coordinate 1 place in front of the end, the solution is found
        if (y == grid.getColumns() - 2) {
            grid.printGrid();
            return true;
        }

        // else return false
        return false;
    }

    // makes all possible new states from the upper state in the queu
    public void makeAllChildren() {
        // gets the first grid of the searchqueu
        Grid old = getNode();

        // get all cars from the state
        Car[] cars = old.getCars();

        // loop through all the cars to make all possible moves
        int i = 1;

        // while there is a car available, make children
        while (cars[i] != null) {
            // copy the grid and make all children with that car and that grid
            // Grid oldCopy = old.gridCopy();
            makeChildrenCar(old, cars[i]);

            // increase counter
            i++;
        }
    }

    // creates grids with the car moved in both direction
    private void makeChildrenCar(Grid old, Car car){

        // get two copies for creating children
        Grid oldPlus = old.gridCopy();
        Grid oldMin = old.gridCopy();

        // move the car in the plus direction
        Grid plus = oldPlus.moveCarPlus(car);

        // if this grid isn't equal to the previous and hasn't been seen before
        // add grid to searchqueu, hashtable and increase counter and path
        if (!oldPlus.equals(plus) && !checkState(plus)) {

            // add the move to the path
            plus.addPath(Integer.toString(car.getId()) +"plus " );
            plus.addCount();

            // add the grid to the queu and the hashtable
            addNode(plus);
            addState(plus);
        }

        // create a grid with the car moved one in the min direction
        Grid min = oldMin.moveCarMin(car);
        if (!oldMin.equals(min) && !checkState(min)) {

            // add the move to the path and increase counter
            min.addPath(Integer.toString(car.getId()) + "min ");
            min.addCount();

            // add the grid to the queu and the hashtable
            addNode(min);
            addState(min);
        }
    }

    public LinkedList getSearchList() {
        return breadthFirst;
    }

    // adds a grid to the queu
    public void addNode(Grid grid) {
        breadthFirst.add(grid);
    }

    // get the first grid from the queu
    public Grid getNode() {
        return breadthFirst.poll();
    }

    // add the grid to the hashtable
    public void addState(Grid grid) {
        stateList.add(grid.toString());
    }

    // check if a grid is already present in the hashtable (the key is unique
    // for the grid)
    public boolean checkState(Grid grid) {
        if (stateList.contains(grid.toString())) {
            return true;
        }
        return false;
    }

    // does the actual search, printing the path included
    public void findSolution(){
        // remember time before beginning
        long timeTrialBefore = System.nanoTime();

        // keeps replacing the first node by all it's children
        // while the grid doesn't match a winning grid
        while (true){
            if (checkIfOK()){
                break;
            }

            makeAllChildren();
        }

        // get time after search
        long timeTrialAfter = System.nanoTime();

        // get the first node (the winning grid)
        Grid good = getNode();

        // print the grid and the animated path
        good.printGrid();
        good.printPath();

        // compute time that was needed to find solution
        long time1 = (timeTrialAfter - timeTrialBefore)/1000000;

        // print all interesting information
        System.out.println("Path: "+good.getPath());
        System.out.println("Number of necessary steps: " + Integer.toString(good.getCount()));
        System.out.println("Time (in milliseconds): " + Long.toString(time1));

    }
}
