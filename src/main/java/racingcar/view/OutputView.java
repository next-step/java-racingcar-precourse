package racingcar.view;

import racingcar.controller.RacingCarResultDto;

import java.util.List;

public class OutputView {

    private static final Character LINE = '-';
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String GAME_RESULT = "실행 결과";
    private static final String GAME_WINNER = "최종 우승자:";

    public static String showLine(int number) {
        String carLine = "";
        for (int line = 0; line < number; line++) {
            carLine += LINE;
        }

        return carLine;
    }

    public void showPlayResult(List<RacingCarResultDto> racingCarResultDtos, int round) {
        System.out.println(GAME_RESULT);

        for (int gameRound = 0; gameRound < round; gameRound++) {
            showByRound(racingCarResultDtos, gameRound);
            System.out.println();
        }
    }

    private void showByRound(List<RacingCarResultDto> racingCarResultDtos, int gameRound) {
        for (int userIndex = 0; userIndex < racingCarResultDtos.size(); userIndex++) {
            RacingCarResultDto racingCarResultDto = racingCarResultDtos.get(userIndex);
            System.out.println(racingCarResultDto.getName() + " : " + showLine(racingCarResultDto.getPositionHistory().get(gameRound)));
        }
    }

    public void showWinners(List<String> winners) {
        System.out.print(GAME_WINNER);
        System.out.println(String.join(",", winners));;
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
