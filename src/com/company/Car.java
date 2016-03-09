package com.company;

/**
 * Created by Sanne on 3-3-2016.
 */
public class Car {
    public int id;
    private boolean direction;
    private int x;
    private int y;
    private int length;

    public Car(boolean direction, int x, int y, int length, int id) {
        this.direction = direction;
        setX(x);
        setY(y);
        this.id = id;
        this.length = length;
    }

    public int getLength(){
        return length;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getId(){
        return id;
    }

   // public Car getCar(int id){

   // }

    public boolean getDirection(){
        return direction;
    }

    public void setX(int x){
        if(x<0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    public void setY(int y){
        if(y<0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }


}
