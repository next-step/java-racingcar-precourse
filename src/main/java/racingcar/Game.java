package racingcar;

public class Game {
    private final GameService gameService;

    public Game(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        try {
            RacingCars racingCars = gameService.createRacingCars();
            gameService.gameStart(racingCars);
            gameService.printWinners(racingCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
