package racing;

public class Mileage {
    private int mileage;

    public Mileage() {
        this.mileage = 0;
    }

    public Mileage(int mileage) {
        this.mileage = mileage;
    }

    public void increase() {
        mileage++;
    }

    @Override
    public boolean equals(Object other) {
        return Comparison.Equals(this, other, obj -> mileage == obj.mileage);
    }
}
