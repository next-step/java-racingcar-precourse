public class Car {

    private final String name;
    private int progress = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public int movingForward(int randNum){
        if (randNum >= 4){
            progress += 1;
            return progress;
        }
        return progress;
    }
}
