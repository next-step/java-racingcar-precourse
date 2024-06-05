package view;

import controller.RacingCarController;
import dto.RacingRequest;
import dto.RacingResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static view.message.ErrorMessage.*;
import static view.message.Message.*;

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
        while (true) {
            try {
                System.out.println(TRIAL_INPUT_MESSAGE.toString());
                int trialNumber = Integer.parseInt(scanner.nextLine());
                if (trialNumber < 1)
                    throw new IllegalArgumentException(INVALID_TRIAL_NUMBER_EXCEPTION_MESSAGE.toString());
                return trialNumber;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_TRIAL_NUMBER_EXCEPTION_MESSAGE.toString());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getCarListWithInputString() {
        while (true) {
            try {
                System.out.println(CAR_NAME_INPUT_MESSAGE.toString());
                String[] carNameSplitStringArray = scanner.nextLine().split(",");
                if(Arrays.stream(carNameSplitStringArray).anyMatch(s -> s.length() > 5))
                    throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE.toString());
                if (Arrays.stream(carNameSplitStringArray).distinct().count() != carNameSplitStringArray.length)
                    throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE.toString());
                return carNameSplitStringArray;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
