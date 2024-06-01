package camp.nextstep.edu.presenter;

import camp.nextstep.edu.presenter.api.RacingCarApi;
import camp.nextstep.edu.presenter.dto.request.Request;

import java.util.Scanner;

public class RacingCarInputDispatcherListener {
    private final RacingCarApi racingCarApi;

    public RacingCarInputDispatcherListener(RacingCarApi racingCarApi) {
        this.racingCarApi = racingCarApi;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!registerRacingCars(scanner)) {
        }
        while (!startRacing(scanner)) {
        }
        scanner.close();
    }

    private boolean registerRacingCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String input = scanner.nextLine();
            racingCarApi.registerRacingCars(Request.of(input));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean startRacing(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            String input = scanner.nextLine();
            racingCarApi.startRacing(Request.of(input));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
