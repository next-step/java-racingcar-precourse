import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateMovePoint {

	private static final int RANDOM_MAX_VAL = 10;

	public List<Integer> makeMovePointList(int carCount) {
		List<Integer> movePointList = new ArrayList<>(carCount);
		for (int i = 0; i < carCount; i++) {
			movePointList.add(new Random().nextInt(RANDOM_MAX_VAL));
		}
		return movePointList;
	}
}
