package racingcar.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    private StringBuilder winnersNameString;
    private Winners winners;

    @BeforeEach
    public void setUp() {
        winnersNameString = new StringBuilder();
        winners = new Winners();
    }


    @Test
    @DisplayName("1명 우승한 사람에 대한 이름 출력")
    public void 단독_우승자_안내_문구_출력() {
        winners.addWinner("phobi");
        List<CarName> winnersName = winners.winnersName();
        for (int i = 0; i < winnersName.size(); i++) {
            winnersNameString.append(winnersName.get(i).getCarName());
            winnersNameString.append(",");
        }

        winnersNameString.deleteCharAt(winnersNameString.length() - 1);

        assertEquals(winnersNameString.toString(), "phobi");
    }

    @Test
    @DisplayName("2명 이상의 우승한 사람에 대한 이름 출력")
    public void 우승자_한_명_이상일_경우_쉼표로_이름_구분하여_출력() {
        Winners winners = new Winners();
        winners.addWinner("phobi");
        winners.addWinner("woni");
        List<CarName> winnersName = winners.winnersName();
        for (int i = 0; i < winnersName.size(); i++) {
            winnersNameString.append(winnersName.get(i).getCarName());
            winnersNameString.append(",");
        }

        winnersNameString.deleteCharAt(winnersNameString.length() - 1);

        assertEquals(winnersNameString.toString(), "phobi,woni");
    }


}
