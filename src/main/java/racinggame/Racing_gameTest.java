package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Racing_gameTest {
	
	@ParameterizedTest
	@CsvSource(value= {"poni,1,0","muu,6,1","eqqus,7,1"}, delimiter=',')
	@DisplayName("자동차 이동 검증")
	void moving(String car_num, int distance, int result) {
		Racing_game game=new Racing_game(car_num);
		game.moving_Car(0, distance);
		assertThat(game.getCars().get(0).get_distance()).isEqualTo(result);
	}

	
	@Test
	@DisplayName("이동거리가 가장 긴 자동차의 Distance 찾기")
	void get_Max_Distance() {
		Racing_game game=new Racing_game("ssing,brung,eqqus");
		game.moving_Car(0, 1);
		game.moving_Car(1, 3);
		game.moving_Car(2, 6);
		assertThat(game.get_distance()).isEqualTo(1);
	}
	
	@Test
	@DisplayName("우승 차량 찾기 로직 검증")
	void is_Winner() {
		Racing_game game=new Racing_game("ssing,brung,eqqus");
		game.moving_Car(0, 1);
		game.moving_Car(1, 3);
		game.moving_Car(2, 6);
		assertThat(game.find_winner(0)).isFalse();
		assertThat(game.find_winner(1)).isFalse();
		assertThat(game.find_winner(2)).isTrue();
		
	}
	
	@Test
	@DisplayName("우승자 리스트 생성 검증")
	void find_Winner() {
		Racing_game game=new Racing_game("Ssing,brung,muu");
		game.moving_Car(0, 1);
		game.moving_Car(1, 3);
		game.moving_Car(2, 6);
		assertThat(game.get_all_winner()).contains("muu");
		
	}
	
	
}
