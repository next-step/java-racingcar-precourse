package controller;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import service.GamePrepareService;
import service.GameService;
import util.Validation;

public class GameController {
    private GamePrepareService gamePrepareService;
    private GameService gameService;

    public GameController() {
    	List<Car> carList = new ArrayList<>();
    	Validation valid = new Validation();
    	gamePrepareService = new GamePrepareService( carList, valid );
    	gameService = new GameService( carList, valid );
    }

    public void start() {
    	int playCount = gamePrepareService.initialize();
    	gameService.racingStart( playCount );
    	gameService.getGameResult();
    }
}
