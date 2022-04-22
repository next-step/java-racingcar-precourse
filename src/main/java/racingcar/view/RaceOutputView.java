package racingcar.view;

import racingcar.domain.dto.RacingCarDto;
import java.util.List;

public class RaceOutputView {
    private final String WINNERS_MESSAGE = "최종 우승자";

    /**
     * 이동 진행 상황 출력
     */
    public void printRaceProgress(List<RacingCarDto> carList) {
        for (RacingCarDto rc : carList) {
            String name = rc.getName();
            String hyphens = getTransformHyphen(rc.getDistance());

            System.out.printf("%s : %s\n", name, hyphens);
        }
    }

    /**
     * 최종 우승자 출력
     */
    public void printWinners(List<RacingCarDto> winners){
        System.out.printf("%s: %s\n", WINNERS_MESSAGE, winners.toString());
    }

    /**
     * 이동 거리 to 하이픈 변환
     */
    private String getTransformHyphen(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
