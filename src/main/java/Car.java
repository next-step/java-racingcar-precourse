public class Car {
    private static final int MOVENUM = 4;
    private final String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
