import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

public class OutputTest {
	@Test
	public void 레이싱카_이동_거리_출력_검증() {
		assertThat(OutputView.mapCount(0)).isEqualTo("");
		assertThat(OutputView.mapCount(1)).isEqualTo("-");
		assertThat(OutputView.mapCount(5)).isEqualTo("-----");
	}
}
