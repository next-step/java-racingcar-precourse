package racing;

public class Mileage {
    private int mileage;

    public static Mileage max(Mileage left, Mileage right) {
        if (left.isGreaterThan(right))
            return left;
        return right;
    }

    private boolean isGreaterThan(Mileage other) {
        return mileage > other.getValue();
    }

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

    @Override
    public String toString() {
        return "Mileage{" + mileage + '}';
    }

    public int getValue() {
        return mileage;
    }
}
