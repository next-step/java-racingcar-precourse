package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {
	@Test
	void 자동차_이름길이_5자_이하인지_검증() {
		assertThatCode(()->{
			new CarName("a");
		}).doesNotThrowAnyException();
		
		assertThatCode(()->{
			new CarName("abdef");
		}).doesNotThrowAnyException();
		
		assertThatThrownBy(()->{
			new CarName("abdefg");
		}).isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(()->{
			new CarName(null);
		}).isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(()->{
			new CarName("");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
