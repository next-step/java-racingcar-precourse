package racingcar;

import racingcar.dto.RacingCarDto;
import racingcar.service.RacingCarExecutor;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarApplication {
    private final Scanner scan = new Scanner(System.in);

    public void run() {
        RacingCarExecutor executor = racingCarExecutor();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(scan.nextLine());

        System.out.println("\n실행 결과");
        var result = executor.execute(times);
        printRacingCarResult(result);

        System.out.printf("최종 우승자 : %s", executor.getWinner().stream()
                .map(RacingCarDto::getName)
                .collect(Collectors.joining(", ")));
    }

    private RacingCarExecutor racingCarExecutor() {
        RacingCarExecutor result = null;
        while (result == null) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

                var carNames = scan.nextLine().split(",");
                result = new RacingCarExecutor(carNames);
            } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] " + ex.getMessage());
            }
        }

        return result;
    }

    private void printRacingCarResult(List<List<RacingCarDto>> result) {
        result.forEach(racing -> {
            racing.forEach(racingCar -> {
                System.out.printf("%s : %s\n",
                        racingCar.getName(), "-".repeat(racingCar.getLocation()));
            });
            System.out.println();
        });

    }
}
