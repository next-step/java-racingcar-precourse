package model;

public class Car {
    private String name;
    private int score;

    Car(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void go() {
        this.score += 1;
    }

    @Override
    public String toString(){
        StringBuilder status = new StringBuilder(this.name + ":");

        for(int i = 0; i<this.score; i++){
            status.append("-");
        }

        return status.toString();
    }
}
