package study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void add() {
		List<String> list = new ArrayList<>();
		list.add(null);
		assertThat(list.size()).isEqualTo(1);
	}
}
