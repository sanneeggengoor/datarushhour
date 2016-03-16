package com.company;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Class for searching breadthfirst through a rush hour game for the best solution
 */

public class Search {
    // the searchclass has a hashtable with all the grids and a linkedlist queu for searching
    Hashtable<String, Grid> stateList;
    LinkedList<Grid> breadthFirst;

    public Search() {
        stateList = new Hashtable<>();
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
        int x = car.getX();
        int y = car.getY();

        // if the 1 car is at 2,4, it is positioned in front of the exit,
        // so return true
        if (x == 2 && y == 4) {
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
            Grid oldCopy = old.gridCopy();
            makeChildrencar(oldCopy, cars[i]);

            // increase counter
            i++;
        }
    }

    // creates grids with the car moved in both direction
    private void makeChildrencar(Grid old, Car car){

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
        stateList.put(grid.toString(), grid);
    }

    // check if a grid is already present in the hashtable (the key is unique
    // for the grid)
    public boolean checkState(Grid grid) {
        if (stateList.containsKey(grid.toString())) {
            return true;
        }
        return false;
    }
}
