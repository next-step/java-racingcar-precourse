package racing;

public class Energy {
    public static final int ENERGY_BOUND = 10;
    private final int level;

    public Energy(int level) {
        validateLevel(level);
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        Energy energy = (Energy) other;
        return level == energy.level;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.level);
    }

    private void validateLevel(int level) {
        if (level >= ENERGY_BOUND)
            throw new IllegalArgumentException("Level should be less than" + ENERGY_BOUND);

        if (level < 0)
            throw new IllegalArgumentException("Level should be positive number");
    }
}
