package racinggame.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameValidationTest {

	@Test
	@DisplayName("입력받는 이름의 상태체크를 생성한다.")
	public void createNameValidation(){
		NameValidation nameValidation = new NameValidation();

		assertThat(nameValidation).isEqualTo(new NameValidation());
	}

	@Test
	@DisplayName("입력받은 이름이 null 이면 error 상태는 true 이다.")
	public void checkNull(){
		NameValidation nameValidation = new NameValidation();

		NameValidation result = nameValidation.checkInputStatus(null);
		assertThat(result.isProblem()).isTrue();
	}

	@Test
	@DisplayName("입력받은 이름이 빈값 이면 error 상태는 true 이다.")
	public void checkEmpty(){
		NameValidation nameValidation = new NameValidation();

		NameValidation result = nameValidation.checkInputStatus("");
		assertThat(result.isProblem()).isTrue();
	}

	@Test
	@DisplayName("입력받는 이름별 크기가 5보다 크면 error 상태는 true 이다.")
	public void isSuitableSize(){
		NameValidation nameValidation = new NameValidation();

		NameValidation result = nameValidation.checkInputStatus("java,racing");
		assertThat(result.isProblem()).isTrue();
	}

	@Test
	@DisplayName("입력받는 이름에 중복이 있으면 error 상태는 true 이다.")
	public void isDuplication(){
		NameValidation nameValidation = new NameValidation();

		NameValidation result = nameValidation.checkInputStatus("aaa,aaa,bbb");
		assertThat(result.isProblem()).isTrue();
	}

}