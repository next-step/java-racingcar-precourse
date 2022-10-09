package racingcar.game;

import racingcar.model.Car;
import racingcar.utils.InputString;
import racingcar.view.io.OutputFunction;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    List<InputString> winnerList;
    public GameResult(List<Car> carList) {
        this.winnerList = new ArrayList<>();

        int maxVal =  getMaxVal(carList);

        for (Car car : carList) {
            addWinnerList(maxVal, car);
        }
    }

    public void printWinnerList(){
        OutputFunction.print("최종 우승자 : ");
        String winList ="";
        for (InputString winner : this.winnerList) {
            winList +=winner.getStrValue();
            winList += ",";
        }

        winList = winList.substring(0, winList.length() - 1);
        OutputFunction.println(winList);
    }

    private int getMaxVal(List<Car> carList) {
        int maxVal =0;
        for (Car car : carList) {
            List<InputString> goStack = car.getGoStack();
            maxVal = Math.max(goStack.size(), maxVal);
        }
        return maxVal;
    }

    private void addWinnerList(int maxVal, Car car) {
        if(maxVal == car.getGoStack().size()){
            winnerList.add(new InputString(car.getCarName()));
        }
    }
}
