package controller;

import service.GameService;
import util.RacingGameUtil;
import view.UserInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private UserInterface userInterface = new UserInterface();
    private GameService gameService = new GameService();

    public int playGame(){
        userInterface.explain();
        prepareRacingCar();
        prepareForTheRound();
        playRound();
        checkTheWinnerCar();
        return  0;
    }




    public int prepareRacingCar(){
        String carNameInput = userInterface.enterCarName();
        LinkedHashMap<String, Integer> carList =  gameService.setCars(carNameInput);
        userInterface.getCarName(carList);

        return 0;
    }

    public int prepareForTheRound() {
       String rounfInput = userInterface.enterNumberOfRounds();
       int validRoundInt = RacingGameUtil.validRoundInt(rounfInput);
       gameService.setRound(validRoundInt);
       userInterface.getNumberOfRounds(validRoundInt);

       return 0;
    }

    public int playRound() {
        int round = gameService.getRound();
        for (int i = 1; i <= round; i++){
            LinkedHashMap<String, Integer> carList = gameService.palyRouound();
            userInterface.printRoundResults(i, carList);

        }
        return 0;
    }

    public int checkTheWinnerCar() {
        LinkedHashMap<String, Integer> winnerCarMap = gameService.우승자가리기();

        List<String> winnerCarList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : winnerCarMap.entrySet()) {
            winnerCarList.add(entry.getKey());
        }

        userInterface.printWinners(winnerCarList);
        return 0;

    }




}
