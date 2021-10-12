package racinggame.model;

public class Car {
    private String name;
    private Score score;

    public Car(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
