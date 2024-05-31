import java.util.*;

public class CustomRandom extends Random {
    private int fixedValues;

    public CustomRandom(int fixedValues) {
        this.fixedValues = fixedValues;
    }

    @Override
    public int nextInt(int bound) {
        return fixedValues;
    }
}
