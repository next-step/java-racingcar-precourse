package view;

import controller.RacingCarController;
import dto.RacingRequest;
import dto.RacingResponse;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RacingGame {

    public Scanner scanner;
    public RacingCarController racingCarController;

    public void init() {
        this.scanner = new Scanner(System.in);
        this.racingCarController = new RacingCarController();
    }

    public void start() {

        init();

        String[] carNameStringArray = getCarListWithInputString();
        int trialNumber = getTrialNumberWithInputString();

        RacingResponse racingResponse = racingCarController.race(RacingRequest.of(carNameStringArray, trialNumber));

        printRaceResult(racingResponse.getRaceResult());
        printWinner(racingResponse.getWinner());
    }

    private void printWinner(List<String> winner) {
    }

    private void printRaceResult(List<Map<String, Integer>> raceResult) {

    }



    private int getTrialNumberWithInputString() {
        return 0;
    }

    private String[] getCarListWithInputString() {
        return null;
    }


}
