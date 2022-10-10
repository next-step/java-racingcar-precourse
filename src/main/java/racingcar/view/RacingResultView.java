package racingcar.view;

import racingcar.domain.RacingResultsMap;

public class RacingResultView {

    public void print(RacingResultsMap racingResultMap) {
        System.out.print("실행 결과 \n" + racingResultMap);
        String winners = "";
        for(String winner : racingResultMap.getWinnerList()) {
            winners += winner +", ";
        }
        System.out.println("최종 우승자 : " + winners.substring(0,winners.length()-2));
    }
}
