package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringJoiner;
import racingcar.model.dto.EnteredCarNames;
import racingcar.model.dto.RaceResult;
import racingcar.model.dto.RoundResult;
import racingcar.model.vo.CarState;

public class RacingView {

    /**
     * 자동차 이름 입력
     *
     * @return 사용자 입력값
     */
    public EnteredCarNames carNamesInput() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return new EnteredCarNames(input);
    }

    /**
     * 시도 횟수 입력
     *
     * @return 사용자 입력값
     */
    public String totalRoundInput() {
        System.out.println("시도할 회수");
        return Console.readLine();
    }

    /**
     * 회차별 실행 결과 출력
     *
     * @param roundResult 경주 진행 결과
     */
    public void roundResultPrint(RoundResult roundResult) {
        for (int i = 0; i < roundResult.getRoundResult().size(); i++) {
            CarState carState = roundResult.getRoundResult().get(i);
            carResultPrint(carState);
        }
        System.out.println();
    }

    /**
     * 자동차별 실행 결과 출력
     *
     * @param carState 자동차 상태
     */
    private void carResultPrint(CarState carState) {
        System.out.print(carState.getCarName() + " : ");
        for (int i = 0; i < carState.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * 우승자 출력
     *
     * @param raceResult 우승자 목록
     */
    public void raceResultPrint(RaceResult raceResult) {
        System.out.print("최종 우승자 : ");
        StringJoiner winnersJoin = new StringJoiner(", ");
        for (String winner : raceResult.getWinners()) {
            winnersJoin.add(winner);
        }
        System.out.println(winnersJoin);
    }

}
