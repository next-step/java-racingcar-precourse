package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void 입력_값이_0에서_3_사이의_값이면_자동차_정지(){
		//given
		Car car = new Car("aaaa");

		//when
		int distanceFor0 = car.move(0);
		int distanceFor3 = car.move(3);


		//then
		Assertions.assertThat(distanceFor0).isEqualTo(0);
		Assertions.assertThat(distanceFor3).isEqualTo(0);
	}

	@Test
	public void 입력_값이_4에서_9_사이의_값이면_자동차_전진(){
		//given
		Car car = new Car("aaaa");

		//when
		int distanceFor4 = car.move(4);
		int distanceFor9 = car.move(9);


		//then
		Assertions.assertThat(distanceFor4).isEqualTo(1);
		Assertions.assertThat(distanceFor9).isEqualTo(2);
	}


}
