import java.util.Objects;

public class Mileage {
    Integer mileage;

    private Mileage(Integer mileage) {
        this.mileage = mileage;
    }

    public static Mileage of(Integer input) {
        return new Mileage(input);
    }

    public void addOne() {
        mileage++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mileage mileage1 = (Mileage) o;
        return Objects.equals(mileage, mileage1.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mileage);
    }
}
