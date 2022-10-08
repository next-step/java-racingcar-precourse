package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ERROR.*;
import static racingcar.constant.SETTING.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.constant.SETTING;
import racingcar.domain.car.MyCarInfo;
import racingcar.domain.car.Component;
import racingcar.domain.car.MyCar;
import racingcar.domain.car.MyCarInfos;
import racingcar.domain.car.factor.CarName;

class CarNameTest {

	@Test
	public void 자동차_이름_길이_유효성_검사(){
		//given
		String str = "pooooo";
		CarName carName = CarName.of(str);

		//when
		//then
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			carName.lengthCheck();
		});

		assertEquals(EXCESS_LENGTH,exception.getMessage());
	}

	@Test
	public void 자동차_이름_빈값_유효성_검사(){
		//given
		String str = "";
		CarName carName = CarName.of(str);

		//when
		//then
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			carName.emptyNameCheck();
		});

		assertEquals(EMPTY_NAME,exception.getMessage());
	}

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
