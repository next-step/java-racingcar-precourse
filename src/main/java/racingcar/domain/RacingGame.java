package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingGame {
    private final ArrayList<RacingCar> carList = new ArrayList<>();

    public ArrayList<RacingCar> getWinnerList() {
        return checkWinner();
    }

    public void setUpRacingCar(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new RacingCar(carName));
        }
    }

    public void carMoving(MovingCheck movingCheck, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            RacingCar car = carList.get(i);
            car.move(movingCheck);
            ResultView.carLineView(car.getCarName(), car.getStatus());
        }
        ResultView.newLine();
    }

    private ArrayList<RacingCar> checkWinner() {
        int winnerPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            winnerPosition = getWinnerPosition(winnerPosition, i);
        }

        ArrayList<RacingCar> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            getWinnerList(winnerPosition, winnerList, i);
        }
        return winnerList;
    }

    private int getWinnerPosition(int winnerPosition, int i) {
        if ( (carList.get(i)).getStatus() > winnerPosition ) {
            winnerPosition = (carList.get(i)).getStatus();
        }
        return winnerPosition;
    }

    private void getWinnerList(int winnerPosition, ArrayList<RacingCar> winnerList, int i) {
        if ( carList.get(i).getStatus() == winnerPosition ) {
            winnerList.add(carList.get(i));
        }
    }
}
