package racingcar.domain.car.collect;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.CarName;
import racingcar.domain.car.MyCar;

class MyCarsTest {

	@Test
	public void 자동차_거리_합_확인(){

		List<MyCar> list = new ArrayList<>();
		list.add(new MyCar(CarName.of("doing"),1));
		list.add(new MyCar(CarName.of("doing"),2));

		MyCars myCars = new MyCars(list);

		assertEquals(1, myCars.currentDistance(0));
		assertEquals(3, myCars.lastDistance());

		List<MyCar> list2 = new ArrayList<>();
		list2.add(new MyCar(CarName.of("poing"),2));
		list2.add(new MyCar(CarName.of("poing"),3));

		MyCars myCars2 = new MyCars(list2);

		assertEquals(2, myCars2.currentDistance(0));
		assertEquals(5, myCars2.lastDistance());

	}

}
