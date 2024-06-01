public class Racing {
    private String[] cars;
    private int[] moveStatus;
    private int leftTries;

    public Racing(String[] cars, int tryCount) {
        this.cars = cars;
        this.moveStatus = new int[cars.length];
        this.leftTries = tryCount;
    }
}
