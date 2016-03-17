package com.company;

/**
 * Class that contains a car.
 */
public class Car {
    public int id;
    private boolean direction;
    private int x;
    private int y;
    private int length;


    // Every car contains a direction, x, y, identity and length
    public Car(boolean direction, int x, int y, int length, int id) {
        this.direction = direction;
        setX(x);
        setY(y);
        this.id = id;
        this.length = length;
    }

    // Copies car by putting all values in a new car
    public Car copyCar(){
        // getting all values of old car
        boolean directionCopy = this.direction;
        int xCopy = this.getX();
        int yCopy = this.getY();
        int idCopy = this.getId();
        int lengthCopy = this.getLength();

        // creating a new car with given values
        Car carCopy = new Car(directionCopy, xCopy, yCopy, lengthCopy, idCopy);

        // return the new car
        return carCopy;
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

    public boolean getDirection(){
        return direction;
    }

    // gives car new integer x, works only if x is greater than 0
    public void setX(int x){
        if(x<0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    // gives car new integer y, works only if y is greater than 0
    public void setY(int y){
        if(y<0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }


}
