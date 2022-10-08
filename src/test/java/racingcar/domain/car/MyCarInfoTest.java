package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.factor.CarName;

class MyCarInfoTest {

	@Test
	public void 자동차_거리_합_확인(){

		List<Component> myCarDistances = new ArrayList<>();
		myCarDistances.add(new MyCar(CarName.of("doing"),1));
		myCarDistances.add(new MyCar(CarName.of("doing"),2));

		MyCarInfo myCarInfo = new MyCarInfo(myCarDistances);

		assertEquals(3, myCarInfo.getDistances());

		List<Component> myCarDistances2 = new ArrayList<>();
		myCarDistances2.add(new MyCar(CarName.of("poing"),1));
		myCarDistances2.add(new MyCar(CarName.of("poing"),3));

		MyCarInfo myCarInfo2 = new MyCarInfo(myCarDistances2);

		assertEquals(4, myCarInfo2.getDistances());

	}

}
