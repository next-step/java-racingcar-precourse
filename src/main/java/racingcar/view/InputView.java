package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Separator;
import racingcar.domain.Cars;
import racingcar.domain.PlayCount;
import racingcar.exception.RacingCarIllegalArgumentException;

public class InputView {

    /**
     * 자동차 이름 리스트 입력
     *
     * @return 자동차 리스트
     */
    public static Cars inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return new Cars(Console.readLine().split(Separator.COMMA));
    }

    /**
     * 시도할 회수 입력
     *
     * @return 시도할 회수
     */
    public static PlayCount inputPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return new PlayCount(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new RacingCarIllegalArgumentException("시도할 회수는 숫자로 입력해주세요.");
        }
    }
}
