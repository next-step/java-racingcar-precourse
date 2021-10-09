package exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class name_Exception_test {
	
	
	@Test
	@DisplayName("숫자 여부 판단")
	void 숫자판단() {
		assertThat(name_Exception.isNum("1234"));
		assertThat(name_Exception.isNum("이건문자열"));
	}
	

}
