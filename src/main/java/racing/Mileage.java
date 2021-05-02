package racing;

public class Mileage {
    public static final String MILEAGE_DASH = "-";
    public static final int INIT_MILEAGE = 0;
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
        this.mileage = INIT_MILEAGE;
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

    public String getValueAsDash() {
        return new String(new char[mileage]).replace("\0", MILEAGE_DASH);
    }
}
