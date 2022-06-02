package racingcar;

import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        try {
            racingService.init();
            racingService.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
