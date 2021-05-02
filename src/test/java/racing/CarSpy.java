package racing;

public class CarSpy extends Car {
    int count = 0;

    public CarSpy() {
        super("spy");
    }

    @Override
    public void injectEnergy(Energy energy) {
        this.count++;
    }
}