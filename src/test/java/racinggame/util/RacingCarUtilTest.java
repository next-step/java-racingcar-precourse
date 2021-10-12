package racinggame.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.model.RacingCar;

public class RacingCarUtilTest {
	@DisplayName("createRacingCar 테스트")
	@Test
	void createRacingCar() {
		RacingCar racingCar = RacingCarUtil.createRacingCar("nankisu");
		assertThat(racingCar).isNotNull();
		assertThat(racingCar.getLocation()).isEqualTo(0);
		assertThat(racingCar.getName()).isEqualTo("nankisu");
	}
	
	@DisplayName("createRacingCars 테스트")
	@Test
	void createRacingCars() {
		List<RacingCar> racingCarList = RacingCarUtil.createRacingCars("nankisu1,nankisu2,nankisu3");
		assertThat(racingCarList).isNotNull();
		assertThat(racingCarList.size()).isEqualTo(3);
		
		RacingCar racingCar1 = racingCarList.get(0);
		assertThat(racingCar1.getLocation()).isEqualTo(0);
		assertThat(racingCar1.getName()).isEqualTo("nankisu1");
		
		RacingCar racingCar2 = racingCarList.get(1);
		assertThat(racingCar2.getLocation()).isEqualTo(0);
		assertThat(racingCar2.getName()).isEqualTo("nankisu2");
		
		RacingCar racingCar3 = racingCarList.get(2);
		assertThat(racingCar3.getLocation()).isEqualTo(0);
		assertThat(racingCar3.getName()).isEqualTo("nankisu3");
	}
}
