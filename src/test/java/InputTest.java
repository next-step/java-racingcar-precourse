import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputTest {
	@Test
	public void 레이싱카_네이밍_분리_테스트() {
		assertThat(new String[] {"K5"}).isEqualTo(InputView.splitCarNames("K5"));
		assertThat(new String[] {"K5", "마티즈"}).isEqualTo(InputView.splitCarNames("K5,마티즈"));
		assertThat(new String[] {"K5", "마티즈"}).isEqualTo(InputView.splitCarNames(" K5, 마티즈 "));
	}
}
