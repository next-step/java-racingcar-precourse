package domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name){
        this.name=name;
        this.distance=0;
    }
    public void forward(){
        this.distance++;
    }
    public int getDistance(){
        return this.distance;
    }
    public StringBuilder roundResult() {
        StringBuilder roundResult = new StringBuilder(this.name + " : ");
        roundResult.append("-".repeat(this.distance));
        return roundResult;
    }
    public StringBuilder createWinner() {
        StringBuilder winner = new StringBuilder();
        winner.append(this.name).append(", ");
        return winner;
    }


}
