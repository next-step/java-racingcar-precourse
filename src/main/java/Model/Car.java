package Model;

import java.util.Random;

public class Car {

    private String name;
    public int distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        if(n >= 4) {
            distance++;
        }
    }

    public void move(int N) {
        if(N >= 4) {
            distance++;
        }
    }

    public String toString() {
        String str = "";

        for(int i=0; i < distance; i++) {
            str = str.concat("-");
        }
        return name + " : " + str;
    }
}
