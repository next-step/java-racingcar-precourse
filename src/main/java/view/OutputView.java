package view;

import domain.RacingCar;
import domain.RacingCarModel.GameResult;
import domain.RacingCarRound;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PROCESS_RESULT = "실행 결과";


    public void printGameResult(GameResult gameResult) {
        System.out.println(PROCESS_RESULT);
        gameResult.racingCarRounds().forEach(this::printRacingRound);
    }

    private void printRacingRound(RacingCarRound round) {
        String roundInfo = round.getRacingCars().stream()
            .map(this::generateCarInfo)
            .collect(Collectors.joining("\n"));
        System.out.println(roundInfo);
        System.out.println(); // 각 라운드 사이에 빈 줄을 추가
    }

    private String generateCarInfo(RacingCar racingCar) {
        return racingCar.getName() + " : " + "-".repeat(racingCar.getPosition());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
