package racingcar.domain.car.collect;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.CarName;
import racingcar.domain.car.MyCar;

class PlayersTest {

	@Test
	public void 우승자_확인(){

		//given
		List<MyCar> myCarList = new ArrayList<>();
		myCarList.add(new MyCar(CarName.of("doing"),1));
		myCarList.add(new MyCar(CarName.of("doing"),2));

		MyCars myCars = new MyCars(myCarList);

		List<MyCar> myCarList2 = new ArrayList<>();
		myCarList2.add(new MyCar(CarName.of("join"),1));
		myCarList2.add(new MyCar(CarName.of("join"),3));

		MyCars myCars2 = new MyCars(myCarList2);

		List<MyCar> myCarList3 = new ArrayList<>();
		myCarList3.add(new MyCar(CarName.of("going"),1));
		myCarList3.add(new MyCar(CarName.of("going"),2));

		MyCars myCars3 = new MyCars(myCarList3);

		List<MyCars> myCarsList = new ArrayList<>();

		myCarsList.add(myCars);
		myCarsList.add(myCars2);
		myCarsList.add(myCars3);

		Players players = new Players(myCarsList);
		//when
		Players winners = players.winnerPlayer();
		//then
		CarNames winnerCarNames = winners.playerCarNames();
		assertTrue(winnerCarNames.getCarNames().contains(CarName.of("join")));
		assertFalse(winnerCarNames.getCarNames().contains(CarName.of("doing")));
		assertFalse(winnerCarNames.getCarNames().contains(CarName.of("going")));
인
	}

	@Test
	public void 공동_우승자_확인(){

		//given
		List<MyCar> myCarList = new ArrayList<>();
		myCarList.add(new MyCar(CarName.of("doing"),1));
		myCarList.add(new MyCar(CarName.of("doing"),2));

		MyCars myCars = new MyCars(myCarList);

		List<MyCar> myCarList2 = new ArrayList<>();
		myCarList2.add(new MyCar(CarName.of("join"),1));
		myCarList2.add(new MyCar(CarName.of("join"),3));

		MyCars myCars2 = new MyCars(myCarList2);

		List<MyCar> myCarList3 = new ArrayList<>();
		myCarList3.add(new MyCar(CarName.of("going"),1));
		myCarList3.add(new MyCar(CarName.of("going"),3));

		MyCars myCars3 = new MyCars(myCarList3);

		List<MyCars> myCarsList = new ArrayList<>();

		myCarsList.add(myCars);
		myCarsList.add(myCars2);
		myCarsList.add(myCars3);

		Players players = new Players(myCarsList);
		//when
		Players winners = players.winnerPlayer();
		//then
		CarNames winnerCarNames = winners.playerCarNames();
		assertTrue(winnerCarNames.getCarNames().contains(CarName.of("join")));
		assertTrue(winnerCarNames.getCarNames().contains(CarName.of("going")));
		assertFalse(winnerCarNames.getCarNames().contains(CarName.of("doing")));

	}

}
