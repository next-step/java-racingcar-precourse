package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MaxMoveTurnTest {
	@Test
	void 최대_이동_횟수가_자연수인지_검증() {
		assertThatCode(()->{
			new MaxMoveTurn("12");
		}).doesNotThrowAnyException();
		
		assertThatCode(()->{
			new MaxMoveTurn("3");
		}).doesNotThrowAnyException();
		
		assertThatThrownBy(()->{
			new MaxMoveTurn("abdefg");
		}).isInstanceOf(NumberFormatException.class);

		assertThatThrownBy(()->{
			new MaxMoveTurn(null);
		}).isInstanceOf(NumberFormatException.class);

		assertThatThrownBy(()->{
			new MaxMoveTurn("");
		}).isInstanceOf(NumberFormatException.class);

		assertThatThrownBy(()->{
			new MaxMoveTurn("0");
		}).isInstanceOf(NumberFormatException.class);

		assertThatThrownBy(()->{
			new MaxMoveTurn("-1");
		}).isInstanceOf(NumberFormatException.class);
	}
}
