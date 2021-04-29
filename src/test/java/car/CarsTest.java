package car;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import util.GameUtil;

public class CarsTest {
	@Test
	public void validateCarNameLengthTest() throws Exception {
		// given
		Cars cars = new Cars(GameUtil.createCars("pobi123,crong,honux"));

		// when
		Method method = cars.getClass().getDeclaredMethod("validateCarNameLength");
		method.setAccessible(true);

		// then
		try {
			method.invoke(cars);
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차의 이름은 5자 이내로 가능합니다.");
		}
	}

}
