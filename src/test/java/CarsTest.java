import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void createNewCars() {
		Throwable thrown = catchThrowable(() -> new Cars("a,b,"));
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}
}
