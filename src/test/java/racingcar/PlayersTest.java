package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayersTest {
	@Test
	void createPlayer() {
		Players players = new Players("jun,jack,tim");
		assertThat(players.getCarNameList()).contains("jun", "jack", "tim");
	}

	@Test
	void playerStaus() {
		Players players = new Players("jun,jack,tim");

		assertThat(players.status()).isEqualTo("jun : \njack : \ntim : \n");
	}

	@Test
	void playerRun() {
		Players players = new Players("jun");
		players.run();
		String statusMsg = players.status();
		System.out.println(statusMsg);
		assertThat(statusMsg.equals("jun : \n") || statusMsg.equals("jun : -\n")).isTrue();
	}
}
