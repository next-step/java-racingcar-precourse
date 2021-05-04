import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.RacingCarName;
import domain.RacingCars;
import domain.RunCount;
import util.StringUtils;
import view.InputView;

public class InputTest {
	@Test
	public void 레이싱카_네이밍_분리_테스트() {
		assertThat(new String[] {"K5"}).isEqualTo(InputView.splitCarNames("K5"));
		assertThat(new String[] {"K5", "마티즈"}).isEqualTo(InputView.splitCarNames("K5,마티즈"));
		assertThat(new String[] {"K5", "마티즈"}).isEqualTo(InputView.splitCarNames(" K5, 마티즈 "));
	}

	@Test
	public void 레이싱카_최소_개수_테스트() {
		RacingCars cars = new RacingCars(new String[] {"K5", "마티즈"});
		assertThat(cars.isNotMinimumCarCount()).isFalse();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RacingCars(new String[] {"K5"}))
			.withMessageMatching("최소 갯수가 맞지 않습니다");
	}

	@Test
	public void 레이싱카_이름_중복_검증() {
		RacingCars cars = new RacingCars(new String[] {"K5", "마티즈"});
		assertThat(cars.containOverlappedCar()).isFalse();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RacingCars(new String[] {"K5", "K5"}))
			.withMessageMatching("이름이 중복되는 레이싱카가 존재합니다");
	}

	@Test
	public void 레이싱카_이름_검증() {
		RacingCarName carName = new RacingCarName("K5");
		assertThat(carName.isValidNameLength()).isTrue();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RacingCarName(""))
			.withMessageMatching("빈 공백 혹은 값을 입력하지 않았습니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RacingCarName("람보르기니 스포츠카"))
			.withMessageMatching("레이싱카의 이름은 길이가 \\d+ 이상 \\d+ 이하 이어야 합니다");
	}

	@Test
	public void 공백_NULL_문자열_검증() {
		assertThat(StringUtils.isEmpty("")).isTrue();
		assertThat(StringUtils.isEmpty(null)).isTrue();
		assertThat(StringUtils.isEmpty("hello")).isFalse();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> StringUtils.validateEmptyString(null))
			.withMessageMatching("빈 공백 혹은 값을 입력하지 않았습니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> StringUtils.validateEmptyString(""))
			.withMessageMatching("빈 공백 혹은 값을 입력하지 않았습니다");
	}

	@Test
	public void 시도_횟수_검증() {
		assertThat(new RunCount("1").isNotValidNumber("1")).isFalse();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RunCount("01")).withMessageMatching("1 이상의 알맞은 숫자로만 입력해주세요");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RunCount("")).withMessageMatching("빈 공백 혹은 값을 입력하지 않았습니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RunCount("ab")).withMessageMatching("1 이상의 알맞은 숫자로만 입력해주세요");
	}
}

