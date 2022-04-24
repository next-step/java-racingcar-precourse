package racingcar;

import java.util.List;

public class CarRaceFlow {

    private CarRaceInputController carRaceInputController;
    private CarRaceOutputController carRaceOutputController;
    private CarStatusGenerator carStatusGenerator;
    private CarResults carResults;
    private Cars cars;

    public CarRaceFlow(){
        carRaceInputController = new CarRaceInputController();
        carRaceOutputController = new CarRaceOutputController();
        carStatusGenerator = new CarStatusGenerator();
    }

    public void excuteCarRace(){

        initGameData();
        simulateRacingGame();
        showGameResult();

    }

    private void showGameResult() {

        List<Boolean> winnerIndexList = carResults.getWinnerIndex();
        List<String> winnerNameList = cars.getWinnerName(winnerIndexList);
        carRaceOutputController.printWinner(winnerNameList);
    }

    private void initGameData(){

        cars = makeCars(carRaceInputController.carNamesInput());
        carResults = makeCarResults(cars.getCarCount(), carRaceInputController.carRaceRoundInput());

    }

    private CarResults makeCarResults(int carCount, String carRoundInput){

        CarResults newCarResult;
        try{
            newCarResult = new CarResults(carCount, carRoundInput);
        }catch(IllegalStateException e){
            carRaceOutputController.printException(e);
            return makeCarResults(cars.getCarCount(), carRaceInputController.carRaceRoundInput());
        }

        return newCarResult;
    }

    private Cars makeCars(String carNamesInput) {

        Cars newCars;
        try{
            newCars = new Cars(carNamesInput);
        }catch(IllegalArgumentException e){
            carRaceOutputController.printException(e);
            return makeCars(carRaceInputController.carNamesInput());
        }

        return newCars;
    }

    private void simulateRacingGame(){
        carRaceOutputController.printRoundResultTitle();
        while(!carResults.isGameEnd()){
            List<CarStatus> carStatusList = carStatusGenerator.generateRandomStatus(cars.getCarCount());
            carResults.playMove(carStatusList);
            carRaceOutputController.printRoundResult(cars, carResults);
        }
    }

}
