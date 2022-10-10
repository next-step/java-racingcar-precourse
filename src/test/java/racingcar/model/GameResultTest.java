package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

@DisplayName("GameResult 테스트")
public class GameResultTest {

	private static Cars cars;
	private static String gameCount;
	private static GameResult gameResult;
	MockedStatic<Randoms> mockRandoms;

	@BeforeEach
	void setup() {
		cars = new Cars.CarsBuilder().carList("a,b,c").build();
		gameCount = "2";
		gameResult = new GameResult.GameResultBuilder().gameCount(gameCount).cars(cars).build();
		mockRandoms = mockStatic(Randoms.class);
	}

	@AfterEach
	void close() {
		mockRandoms.close();
	}

	@DisplayName("GameResult Builder 생성 테스트")
	@Test
	void createGameResultBuilder() {
		// given // when
		GameResult gameResult = new GameResult.GameResultBuilder().gameCount(gameCount).cars(cars).build();
		// then
		assertAll(
			() -> assertThat(gameResult).isInstanceOf(GameResult.class),
			() -> assertThat(gameResult.getCars().hashCode()).isEqualTo(cars.hashCode()),
			() -> assertThat(gameResult.getGameCount()).isEqualTo(Integer.parseInt(gameCount))
		);
	}

	@DisplayName("GameResult List<Car>를 자동차 전진 결과 List<String>으로 변환하는 메소드 테스트")
	@Test
	void convertCarListToMoveResultList() {
		// given // when
		String moveCarList = gameResult.convertCarListToMoveResultList();
		// then
		assertThat(moveCarList).isEqualTo("a : \nb : \nc : \n");
	}

	@DisplayName("GameCount만큼 자동차를 이동시키는 메소드 테스트")
	@Test
	void moveCarUsingGameCount() {
		// given // when
		mockRandoms.when(
			() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(5, 5);
		gameResult.moveCars();
		// then
		assertThat(gameResult.getCars().getCarList().get(0).getForward()).isEqualTo(2);
		assertThat(gameResult.getCars().getCarList().get(0).getStop()).isZero();
	}

	@DisplayName("List<Car>에 존재하는 자동차들의 전진 횟수를 비교하여 우승자를 만들어주는 메소드 테스트")
	@Test
	void createWinnerToCarList() {
		// given
		mockRandoms.when(
			() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(5, 5);
		gameResult.moveCars();
		// when
		gameResult.createWinner();
		// then
		assertThat(gameResult.getWinner()).isEqualTo("a,b,c");
	}
}