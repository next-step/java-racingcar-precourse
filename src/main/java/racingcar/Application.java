package racingcar;

public class Application {

    private static RacingCarService racingCarService;

    public static void main(String[] args) {
        racingCarService = new RacingCarService();
        racingCarService.play();
    }
}
