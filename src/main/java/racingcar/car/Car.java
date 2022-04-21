package racingcar.car;

public class Car {
    public static int GO_MIN_SCORE = 4;

    String name;
    int move;

    public Car(String name){
        this.name = name;
    }

    public void inputScore(int score){
        if (score >= GO_MIN_SCORE){
            go();
        }
    }

    public void go(){
        this.move += 1;
    }

    public int getMove(){
        return this.move;
    }

    public String getName(){
        return this.name;
    }

}
