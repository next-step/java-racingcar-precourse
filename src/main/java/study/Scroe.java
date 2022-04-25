package study;

public class Scroe {
    private int score;
    private double doubleScore;

    public Scroe(int score) {
        validateScore(score);
        this.score = score;
    }

    public Scroe(double doubleScore) {
        validateDobuleScore(doubleScore);
        this.doubleScore = doubleScore;
    }

    private void validateScore(int score) {
        //...
    }

    private void validateDobuleScore(double doubleScore) {
        //...
    }
}
