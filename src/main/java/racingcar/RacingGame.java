package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class RacingGame {
    private static int MAX_POSITION = 0;
    Cars cars = new Cars();
    ArrayList<Car> attendCarsList = new ArrayList<>();
    ArrayList<String> winnerList = new ArrayList<>();

    RacingGame() {}

    public void start(){
        cars.setAttendCarList();
        attendCarsList = cars.getCarList();
        Game game = setGameRound();
        run(attendCarsList, game.getRound());
        printWinner(attendCarsList);
    }

    private void printWinner(ArrayList<Car> attendCarsList) {
        String winnerList = getWinnerList(attendCarsList);
        System.out.println("최종 우승자: "+winnerList);
    }

    private String getWinnerList(ArrayList<Car> attendCarsList) {
        setMaxPosition(attendCarsList);
        for(int idx = 0; idx < attendCarsList.size(); idx++){
            setWinnerList(attendCarsList.get(idx));
        }
        String result = String.join(", ", winnerList);
        return result;
    }

    private void setWinnerList(Car car) {
        if(MAX_POSITION == car.getPosition()){
            winnerList.add(car.getName());
        }
    }

    public void setMaxPosition(ArrayList<Car> attendCarsList) {
        for(int idx = 0; idx < attendCarsList.size(); idx++){
            isMax(attendCarsList.get(idx));
        }
    }

    private void isMax(Car car) {
        if(MAX_POSITION < car.getPosition()){
            MAX_POSITION = car.getPosition();
        }
    }


    void run(ArrayList<Car> attendCarList, int round){
        for(int idx = 0; idx < round; idx++){
            runCar(attendCarList);
            System.out.println();
        }
    }

    private void runCar(ArrayList<Car> attendCarList) {
        for(int idx = 0; idx < attendCarList.size(); idx++){
            attendCarList.get(idx).moveOrStop();
            attendCarList.get(idx).printCarNameAndPosition();
        }
    }

    Game setGameRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        int round = inputGameRound();
        Game game = null;
        try{
            game = new Game(round);
        } catch (IllegalArgumentException e){
            System.out.println(e);
            setGameRound();
        }
        return game;
    }

    int inputGameRound(){
        String inputGameRound = Console.readLine();
        int gameRound = Integer.parseInt(inputGameRound);
        return gameRound;
    }

}
