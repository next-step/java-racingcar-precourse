package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.Message;
import racingcar.controller.RacingCarGame;
import racingcar.domain.factory.CarFactory;
import racingcar.validator.count.ValidatorCount;

public class GameMachine {
    RacingCarGame game;
    CarFactory carFactory;

    public GameMachine setCarFactory(CarFactory carFactory){
        this.carFactory = carFactory;
        return this;
    }

    public GameMachine setRacingCarGame(RacingCarGame game){
        this.game = game;
        return this;
    }

    private void checkPrepareGame() throws IllegalStateException{
        if(carFactory == null){
            throw new IllegalStateException(Message.ERROR_CAR_FACTORY_NULL);
        }
        if(game == null){
            throw new IllegalStateException(Message.ERROR_RACING_CAR_GAME_NULL);
        }
    }

    public void run(){
        try {

            checkPrepareGame();

            processGame();

        }catch (Exception e){
            System.out.printf(Message.FORMAT_ERROR_PRINT, e.getMessage());
        }
    }

    private void processGame(){
        String input = inputCars();
        int gameCnt = inputCnt();

        game.setCars(carFactory.makeCar(input));

        playGames(gameCnt);

        String winner = game.findWinner();

        printWinner(winner);
    }

    private String inputCars() throws IllegalArgumentException{
        System.out.println(Message.GUIDE_INPUT_CAR_NAME);
        String input = Console.readLine();
        System.out.println(input);

        return input;
    }

    private int inputCnt() throws IllegalArgumentException{
        System.out.println(Message.GUIDE_INPUT_COUNT);
        return (new ValidatorCount()).validateCnt();
    }

    private void playGames(int gameCnt){
        for (int i = 0; i< gameCnt; i++){
            game.play();
        }
    }

    private void printWinner(String winner){
        System.out.printf(Message.FORMAT_WINNER_PRINT, winner);
    }
}
