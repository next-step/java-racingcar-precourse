package racinggame.controller;

import racinggame.model.Car;
import racinggame.view.View;

import java.util.ArrayList;

import static nextstep.utils.Console.readLine;

public class RacingGameController {

    private static final String RUN_TEXT = "-";
    private static final String RUN_NUMBER_ZERO = "";
    private static final String DIVISION_MARK = ",";

    private ArrayList<Car> carArrayList;
    private View view;

    public RacingGameController(ArrayList<Car> carArrayList, View view) {
        this.carArrayList = carArrayList;
        this.view = view;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void setCarArrayList(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String readInputCarNames() {
        this.view.getInputView().printInputCarName();
        return readLine();
    }

    public String readInputRunNumber() {
        this.view.getInputView().printInputRunNumber();
        return readLine();
    }

    public void updateRacingResult() {

        for(int i = 0; i < this.carArrayList.size(); i++) {
            int runNumber = this.carArrayList.get(i).getScore().getRunNumber().intValue();
            StringBuilder carRunNumber = new StringBuilder();

            for(int j = 0; j < runNumber; j++) {
                carRunNumber.append(RUN_TEXT);
            }
            this.view.getOutputView().printOutputRacingResult(this.carArrayList.get(i).getName(), carRunNumber.toString());
        }

        this.view.getOutputView().printOutputLine();
    }


    public String checkWinner() {

        int carArrayListSize = this.getCarArrayList().size();
        int maxRunNumber = 0;
        StringBuilder winner = new StringBuilder();
        for (int i = 0; i < carArrayListSize; i++) {

            if (checkRunNumberZero(i))
                continue;

            if (checkRunNumberMaxNumber(maxRunNumber, winner, i))
                continue;

            maxRunNumber = checkRunNumberOverMaxNumber(maxRunNumber, winner, i);
        }

        return winner.toString();
    }

    private int checkRunNumberOverMaxNumber(int maxRunNumber, StringBuilder winner, int i) {
        if(getCarArrayList().get(i).getScore().getRunNumber() > maxRunNumber) {
            maxRunNumber = getCarArrayList().get(i).getScore().getRunNumber();
            winner.setLength(0);
            winner.append(getCarArrayList().get(i).getName());
        }
        return maxRunNumber;
    }

    private boolean checkRunNumberMaxNumber(int maxRunNumber, StringBuilder winner, int index) {
        if (getCarArrayList().get(index).getScore().getRunNumber() == maxRunNumber) {
            winner.append(DIVISION_MARK);
            winner.append(getCarArrayList().get(index).getName());
            return true;
        }
        return false;
    }

    private boolean checkRunNumberZero(int index) {
        if (getCarArrayList().get(index).getScore().getRunNumber() == 0) {
            return true;
        }
        return false;
    }
}
