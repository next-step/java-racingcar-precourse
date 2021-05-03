package util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Car;
import model.Cars;

public class GameUtilTest {

	public static final int RANDOM_NUM_TEST_SIZE = 100;

	@Test
	@DisplayName("입력받은 문자열(자동차 이름)에 대한 공백제거 테스트")
	public void removeAllSpaceInCarNameTest() {
		// given
		String input = "       pobi   ,    crong    ,     honux";
		// when
		assertThat(GameUtil.removeAllSpaceInCarName(input)).isEqualTo("pobi,crong,honux");
	}

	@Test
	@DisplayName("입력받은 문자열에 대해서 콤마(,)기준으로 잘 나누는지 테스트")
	public void splitNameByCommaTest() {
		// given
		String input = "pobi,crong,honux";

		// when
		String[] strArray = GameUtil.splitNameByComma(input);

		// then
		assertThat(strArray.length).isEqualTo(3);
		assertThat(strArray[0]).isEqualTo("pobi");
		assertThat(strArray[1]).isEqualTo("crong");
		assertThat(strArray[2]).isEqualTo("honux");
	}

	@Test
	@DisplayName("랜덤한 숫자가 0에서 9사이 인지 100번 테스트")
	public void generateRandomNumTest() {
		for (int i = 0; i < RANDOM_NUM_TEST_SIZE; i++) {
			int num = GameUtil.generateRandomNum();
			assertThat(num).isGreaterThanOrEqualTo(0);
			assertThat(num).isLessThanOrEqualTo(9);
		}
	}

	@Test
	@DisplayName("랜덤한 숫자가 고르게 선택되는지 테스트")
	public void checkEvenlyLayOutRandomNumTest() {
		int[] count = new int[GameUtil.RANDOM_NUM_MAX + 1];
		for (int i = 0; i < RANDOM_NUM_TEST_SIZE; i++) {
			count[GameUtil.generateRandomNum()]++;
		}

		int average = 10;
		int standardDeviation = 0;
		for (int i = 0; i < 10; i++) {
			standardDeviation += (count[i] - average) * (count[i] - average);
		}
		standardDeviation /= count.length;
		standardDeviation = (int)Math.sqrt(standardDeviation);
		//System.out.println(standardDeviation);
		assertThat(standardDeviation).isLessThanOrEqualTo(average / 2);
	}

	@Test
	@DisplayName("콤마를 구분자로 하는 문자열로 Cars가 잘 구성되는지 테스트")
	public void createCarsTest() {
		// given
		Cars cars = new Cars(GameUtil.createCars("pobi,crong,honux"));

		// when
		List<Car> carList = cars.getCarList();

		// then
		assertThat(carList.size()).isEqualTo(3);
		assertThat(carList.get(0).getName()).isEqualTo("pobi");
		assertThat(carList.get(1).getName()).isEqualTo("crong");
		assertThat(carList.get(2).getName()).isEqualTo("honux");
	}

	@Test
	@DisplayName("Car 객체의 positon 값에 따라 우승자의 리스트를 잘 반환하는지 테스트")
	public void getFirstPositionCarListTest() {
		// given
		Cars cars = new Cars(GameUtil.createCars("pobi,crong,honux"));
		List<Car> carList = cars.getCarList();

		// when #1
		carList.get(0).setPosition(5);
		List<Car> firstPositionCarList = GameUtil.getFirstPositionCarList(carList);

		// then #1
		assertThat(carList.get(0).getName()).isEqualTo("pobi");
		assertThat(firstPositionCarList.size()).isEqualTo(1);
		assertThat(firstPositionCarList.get(0).getName()).isEqualTo("pobi");

		// when #2
		carList.get(1).setPosition(5);
		firstPositionCarList = GameUtil.getFirstPositionCarList(carList);

		// then #2
		assertThat(carList.get(0).getName()).isEqualTo("pobi");
		assertThat(carList.get(1).getName()).isEqualTo("crong");
		assertThat(firstPositionCarList.size()).isEqualTo(2);
		assertThat(firstPositionCarList.get(0).getName()).isEqualTo("pobi");
		assertThat(firstPositionCarList.get(1).getName()).isEqualTo("crong");

		// when #3
		carList.get(2).setPosition(10);        // honux가 단독 1등 일때
		firstPositionCarList = GameUtil.getFirstPositionCarList(carList);

		// then #3
		assertThat(carList.get(2).getName()).isEqualTo("honux");
		assertThat(firstPositionCarList.size()).isEqualTo(1);
		assertThat(firstPositionCarList.get(0).getName()).isEqualTo("honux");
	}

	@Test
	@DisplayName("주어진 값이 움직일 수 있는 값인지 테스트")
	public void isMovableTest() {
		for (int i = 0; i <= 3; i++) {
			assertThat(GameUtil.isMovable(i)).isFalse();
		}
		for (int i = 4; i <= 9; i++) {
			assertThat(GameUtil.isMovable(i)).isTrue();
		}
	}

}
