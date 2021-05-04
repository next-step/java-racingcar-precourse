package racing.game.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AcceleratorTest {
	@Test
	@DisplayName("전진 여부 전달을 검증 한다.")
	public void accelerate() { //Alt + Shift + F10 : 테스트 실행
		// assertThat(Accelerator.validNo(9)).isTrue();
		// assertThat(Accelerator.validNo(4)).isTrue();
		// assertThat(Accelerator.validNo(3)).isFalse();
		// assertThat(Accelerator.validNo(0)).isFalse();
		assertThat(Accelerator.isMove()).isFalse();
	}

	@RepeatedTest(100)
	@DisplayName("0 ~ 9 까지 (유효 한)숫자 생성 검증 한다")
	public void validNo() {
		assertThat(Accelerator.generateRandomNum()).isBetween(0, 9);
	}

}