package racinggame.manage;

import racinggame.manage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validating_test {
	
	@Test
	@DisplayName("숫자 검증")
	void isNum() {
		assertThat(Vaildating.IsNum("12345"));
		assertThat(Vaildating.IsNum("12345"));
	}
	
	@Test
	@DisplayName("자동차 이름 검증")
	void Name_len() {
		assertThat(Vaildating.CarName_len("bungbung")).isFalse();
		assertThat(Vaildating.CarName_len("brung")).isTrue();
	}
	
	@Test
	@DisplayName("게임 시작 가능 여부")
	void game_start() {
		assertThat(Vaildating.game_playing("brung,eqqus,ssing")).isTrue();
		assertThat(Vaildating.game_playing("brung,brung,eqqus,ssing,Muu")).isFalse();
		
	}
	

}
