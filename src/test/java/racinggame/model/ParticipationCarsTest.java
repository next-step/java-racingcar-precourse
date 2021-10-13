package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipationCarsTest {
	private static final String TOM = "tom";
	private static final String DICK = "dick";
	private static final String HARRY = "harry";
	private static final String POTTER = "potter";
	private static final String DELIMITER_COLON = " : ";
	
	private ParticipationCars cars;

	@BeforeEach
	void setUp() {
		cars = new ParticipationCars();
		cars.enterRace(new Car(TOM));
		cars.enterRace(new Car(DICK));
		cars.enterRace(new Car(HARRY));
	}

	@DisplayName("RoundResult 에 의도한 결과 포멧이 적용되었는지 테스트")
	@Test
	void startRound() {
		String roundResultStr = cars.startRound().getRoundResultStr();
		assertThat(roundResultStr).contains(TOM, DICK, HARRY, DELIMITER_COLON);
	}

	@DisplayName("winner가 포지션이 가장 높은 자동차의 이름을 리턴하는지 테스트")
	@Test
	void createWinner() {
		Car car = new Car(POTTER);
		car.move(CarAction.GO);
		cars.enterRace(car);
		Winner winner = cars.createWinner();
		assertThat(winner.getWinnerName()).isEqualTo(POTTER);
	}
}