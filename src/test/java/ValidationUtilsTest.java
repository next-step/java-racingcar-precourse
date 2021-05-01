import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
	@Test
	@DisplayName("자동차_상태_변경_테스트")
	void carStatusChangeTest() {
		assertThat(ValidationUtils.carStatusChange(1)).isEqualTo(CarStatus.STOP);
		assertThat(ValidationUtils.carStatusChange(2)).isEqualTo(CarStatus.STOP);
		assertThat(ValidationUtils.carStatusChange(3)).isEqualTo(CarStatus.STOP);
		assertThat(ValidationUtils.carStatusChange(4)).isEqualTo(CarStatus.MOVE);
		assertThat(ValidationUtils.carStatusChange(5)).isEqualTo(CarStatus.MOVE);
		assertThat(ValidationUtils.carStatusChange(6)).isEqualTo(CarStatus.MOVE);
		assertThat(ValidationUtils.carStatusChange(7)).isEqualTo(CarStatus.MOVE);
		assertThat(ValidationUtils.carStatusChange(8)).isEqualTo(CarStatus.MOVE);
		assertThat(ValidationUtils.carStatusChange(9)).isEqualTo(CarStatus.MOVE);
	}
}
