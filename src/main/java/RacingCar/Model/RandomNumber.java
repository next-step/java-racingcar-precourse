package Model;

public class RandomNumber {
    public static int generateRanNum() {
        return (int) (Math.random() * 9) + 1;
    }
}
