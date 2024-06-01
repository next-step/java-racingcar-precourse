package model;

public class Car {
    private String carname;
    private int move;

    public Car(String carname) {
        this.carname = carname;
        this.move = 0;
    }
    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void moveCar(int randNum){
        if(randNum>=4){
            move += 1;
        }
    }
}
