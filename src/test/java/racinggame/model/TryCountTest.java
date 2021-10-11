package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryCountTest {

	private TryCount tryCount;

	@BeforeEach
	void setUp() {
		this.tryCount = new TryCount(1);
	}

	@Test
	void TryCount_생성_검증() {
		assertThat(tryCount).isNotNull();
	}

	@Test
	void count_감소_검증() {
		assertThat(tryCount.getCount()).isEqualTo(1);
		tryCount.decreaseCount();
		assertThat(tryCount.getCount()).isZero();
		tryCount.decreaseCount();
		assertThat(tryCount.getCount()).isZero();
	}

	@Test
	void count가_0인지_검증() {
		assertThat(tryCount.getCount()).isEqualTo(1);
		tryCount.decreaseCount();
		assertThat(tryCount.isZeroCount()).isTrue();
	}
}
