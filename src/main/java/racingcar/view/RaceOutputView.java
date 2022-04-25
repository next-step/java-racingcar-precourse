package racingcar.view;

import racingcar.domain.dto.RacingCarDto;

import java.util.List;

public class RaceOutputView implements OutputView<RacingCarDto, String> {
    private final String WINNERS_MESSAGE = "최종 우승자";

    /**
     * 이동 진행 상황 출력
     */
    @Override
    public void printRaceProgress(List<RacingCarDto> carList) {
        for (RacingCarDto rc : carList) {
            String name = rc.getName();
            String hyphens = getHyphenChars(rc.getDistance());

            System.out.printf("%s : %s\n", name, hyphens);
        }
        System.out.println();
    }

    /**
     * 최종 우승자 출력
     */
    @Override
    public void printWinners(List<String> winners) {
        System.out.printf("%s: %s\n", WINNERS_MESSAGE, String.join(",", winners));
    }

    /**
     * 이동 거리 to 하이픈 변환
     */
    private String getHyphenChars(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
