public class ValidationUtils {
	public static CarStatus carStatusChange(int number) {
		if (number > 3) {
			return CarStatus.MOVE;
		}

		return CarStatus.STOP;
	}
}
