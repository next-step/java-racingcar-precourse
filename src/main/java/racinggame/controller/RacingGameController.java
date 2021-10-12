package racinggame.controller;

import racinggame.model.Car;
import racinggame.view.View;

import java.util.ArrayList;

import static nextstep.utils.Console.readLine;

public class RacingGameController {

    private static final String RUN_TEXT = "-";
    private static final String RUN_NUMBER_ZERO = "";

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
}
