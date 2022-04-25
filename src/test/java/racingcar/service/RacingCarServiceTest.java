package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarDto;

public class RacingCarServiceTest {
	private RacingCarDto racingCarDto;
	private RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();

	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장()")
	@Test
	void repository에_RacingCar_저장() {
		RacingCarDto racingCarDto = new RacingCarDto("pobi2");
		racingCarRepository.initSaveRacingCar(racingCarDto);
		assertEquals(racingCarDto.getCarName(), racingCarRepository.getRacingCarByName("pobi2").getCarName());
	}

	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장_후_자동차_전진_또는_정지()")
	@Test
	void repository에_RacingCar_저장_후_자동차_전진_또는_정지() {
		racingCarDto = RacingCarDto.builder().carName("pobi2").build();
		racingCarRepository.initSaveRacingCar(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
	}

}
