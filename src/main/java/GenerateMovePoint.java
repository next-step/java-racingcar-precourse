import java.util.Random;

public class GenerateMovePoint {

	private static final int RANDOM_MAX_VAL = 10;

	public static int makeMovePoint() {
		return new Random().nextInt(RANDOM_MAX_VAL);
	}
}
