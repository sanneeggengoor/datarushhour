package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by Sanne on 9-3-2016.
 */
public class Search {
    ArrayList<Car> carList;
    Hashtable<String,Grid> stateList;
    LinkedList<Grid> breadthFirst;

    public Search(){
        carList = new ArrayList<>(30);
        stateList = new Hashtable<>();
        breadthFirst = new LinkedList<>();
    }

    public void makeAllChildren(){
        Grid old = getNode();
        int i = 1;
        Car[] cars = old.getCars();
        while (cars[i]!=null){
            Grid plus = old.moveCarPlus(cars[i]);
            if (!old.equals(plus)){
                addNode(plus);
            }
            Grid min = old.moveCarMin(cars[i]);
            if (!old.equals(min)){
                addNode(min);
            }
        }
    }

    public LinkedList getSearchList(){
        return breadthFirst;
    }

    public void addNode(Grid grid){
        breadthFirst.add(grid);
    }

    public Grid getNode(){
        return breadthFirst.poll();
    }
    public void addState(Grid grid){
        stateList.put(grid.toString(),grid);
    }

    public boolean checkState(Grid grid){
        if (stateList.containsKey(grid.toString())){
            return true;
        }
        return false;
    }

    public void addCarList(Car car4list){
        int id = car4list.getId();
        carList.add(id,car4list);
    }

    public void changeCarList(Car car4list){
        int id = car4list.getId();
        carList.remove(id);
        carList.add(id, car4list);
    }
}
