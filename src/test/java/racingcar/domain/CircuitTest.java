package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CircuitTest {

    @Test
    @DisplayName("서킷은 부여받은 문자열로 레이싱카를 만든다")
    void 서킷은_부여받은_문자열로_레이싱카를_만든다() {
        Circuit circuit = new Circuit();
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("alpha");
        nameList.add("bravo");
        nameList.add("delta");
        circuit.makeRacingCars(nameList);
        assertThat(circuit.getRacingCars().get(0).getName()).isEqualTo("alpha");
        assertThat(circuit.getRacingCars().get(1).getName()).isEqualTo("bravo");
        assertThat(circuit.getRacingCars().get(2).getName()).isEqualTo("delta");
    }

    @Test
    @DisplayName("서킷은 부여받은 숫자로 주행바퀴수를정한다")
    void 서킷은_부여받은_숫자로_주행바퀴수를_정한다() {
        Circuit circuit = new Circuit();
        circuit.insertLapCount(5);
        assertThat(circuit.getLapCount().getLapCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("서킷은 주행바퀴를 돌 때마다 각 레이싱카들은 전진하거나 멈춘다")
    void 서킷은_주행바퀴를_돌_때마다_각_레이싱카들은_전진하거나_멈춘다() {
        Circuit circuit = new Circuit();
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("alpha");
        nameList.add("bravo");
        nameList.add("delta");
        circuit.makeRacingCars(nameList);
        circuit.insertLapCount(2);
        circuit.runLap();
        assertThat(circuit.getRacingCars().get(0).getRaceProgress()).isGreaterThanOrEqualTo(0);
        assertThat(circuit.getRacingCars().get(1).getRaceProgress()).isGreaterThanOrEqualTo(0);
        assertThat(circuit.getRacingCars().get(2).getRaceProgress()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("서킷은 주행을 마치면 주행의 승리자는 한명 이상이다다")
    void 서킷은_주행을_마치면_주행의_승리자는_한명_이상이다() {
        Circuit circuit = new Circuit();
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("alpha");
        nameList.add("bravo");
        nameList.add("delta");
        circuit.makeRacingCars(nameList);
        circuit.insertLapCount(2);
        circuit.runLap();
        ArrayList<String> winners = circuit.getWinners();
        assertThat(winners.size()).isGreaterThan(0);
    }
}
