package view;

import domain.RacingCar;
import domain.RacingCarModel.GameResult;
import domain.RacingCarRound;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PROCESS_RESULT = "실행 결과";
    private static final String ERROR_PREFIX = "[Error]";


    public void printGameResult(GameResult gameResult) {
        System.out.println(PROCESS_RESULT);
        gameResult.racingCarRounds().forEach(this::printRacingRound);
        System.out.println("최종 우승자: " + getWinnerResult(gameResult));
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

    private String getWinnerResult(GameResult gameResult) {
        RacingCarRound lastRound = gameResult.racingCarRounds()
            .get(gameResult.racingCarRounds().size() - 1);
        int maxPosition = getMaxPosition(lastRound);
        List<String> winners = findWinners(lastRound, maxPosition);

        return String.join(", ", winners);
    }

    private int getMaxPosition(RacingCarRound round) {
        return round.getRacingCars().stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }

    private List<String> findWinners(RacingCarRound round, int maxPosition) {
        return round.getRacingCars().stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }


    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
