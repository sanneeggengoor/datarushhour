package com.company;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by Sanne on 9-3-2016.
 */
public class Search {
    Hashtable<String, Grid> stateList;
    LinkedList<Grid> breadthFirst;

    public Search() {
        stateList = new Hashtable<>();
        breadthFirst = new LinkedList<>();
    }

    public boolean checkIfOK() {
        LinkedList<Grid> node = getSearchList();
        Grid grid = node.peek();
        Car[] cars = grid.getCars();
        Car car = cars[1];
        int x = car.getX();
        int y = car.getY();
        if (x == 2 && y == 4) {
            grid.printGrid();

            return true;


        }
        return false;
    }

    public void makeAllChildren() {
        Grid old = getNode();


        int i = 1;
        Car[] cars = old.getCars();
        while (cars[i] != null) {
            Grid oldCopy = old.gridCopy();
            makeChildrencar(oldCopy, cars[i]);
            i++;
        }
    }

    private void makeChildrencar(Grid old, Car car){
        Grid oldplus = old.gridCopy();
        Grid oldmin = old.gridCopy();
        Grid plus = oldplus.moveCarPlus(car);
        if (!oldplus.equals(plus) && !checkState(plus)) {
            addNode(plus);
            addState(plus);
            System.out.println(car.getId()+"plus");
            plus.printGrid();
        }
        Grid min = oldmin.moveCarMin(car);
        if (!oldmin.equals(min) && !checkState(min)) {
            addNode(min);
            addState(min);
            System.out.println(car.getId()+"min");
            min.printGrid();
        }
    }

    public LinkedList getSearchList() {
        return breadthFirst;
    }

    public void addNode(Grid grid) {
        breadthFirst.add(grid);
    }

    public Grid getNode() {
        return breadthFirst.poll();
    }

    public void addState(Grid grid) {
        stateList.put(grid.toString(), grid);
    }

    public boolean checkState(Grid grid) {
        if (stateList.containsKey(grid.toString())) {
            return true;
        }
        return false;
    }
}
