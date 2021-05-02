package racing.race;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import racing.car.Car;
import racing.car.CarName;
import racing.car.Cars;

class RaceTest {
	private List<String> carNameStrings;
	private int tryCount;

	private Race race;

	@BeforeEach
	void init() {
		this.carNameStrings = Arrays.asList("pobi", "crong", "honux");
		this.tryCount = 5;

		this.race = new Race(String.join(",", this.carNameStrings), this.tryCount);
	}

	@DisplayName("사용자의 입력값을 자동차들과 라운드로 변환한다.")
	@Test
	void 사용자의_입력값을_자동차들과_라운드로_변환한다() {
		Cars cars = this.race.getCars();
		Round round = this.race.getRound();
		List<String> carNameStrings = new ArrayList<>();
		for (Car car : cars.getCars()) {
			CarName carName = car.getCarName();
			carNameStrings.add(carName.getName());
		}

		assertTrue(carNameStrings.containsAll(this.carNameStrings));
		assertEquals(tryCount, round.getVal());
	}

	@DisplayName("사용자가 입력한 시도 횟수 만큼 라운드 기록이 기록 되어야 한다.")
	@Test
	void 사용자가_입력한_시도_횟수_만큼_라운드_기록이_기록_되어야_한다() {
		RaceRecord raceRecord = this.race.startRace();
		List<RoundRecord> roundRecords = raceRecord.getRoundRecords();

		assertEquals(tryCount, roundRecords.size());
	}

	@DisplayName("경주를 완료하면 우승한 자동차 이름을 반환한다.")
	@RepeatedTest(5)
	void 경주를_완료하면_우승한_자동차_이름을_반환한다() {
		RaceRecord raceRecord = this.race.startRace();
		List<CarName> winners = raceRecord.getWinners();
		List<String> carNameStrings = new ArrayList<>();
		for (CarName carName : winners) {
			carNameStrings.add(carName.getName());
		}

		assertTrue(this.carNameStrings.containsAll(carNameStrings));
	}
}
