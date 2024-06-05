package view;

import controller.RacingGameController;
import dto.RacingRequest;
import dto.RacingResponse;
import view.message.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static view.message.ErrorMessage.*;
import static view.message.Message.*;

public class RacingGame {

    public Scanner scanner;
    public RacingGameController racingGameController;
    private final int CAR_NAME_MAX_LENGTH = 5;

    public void init() {
        this.scanner = new Scanner(System.in);
        this.racingGameController = new RacingGameController();
    }

    public void start() {

        init();

        String[] carNameStringArray = getCarListWithInputString();
        int trialNumber = getTrialNumberWithInputString();

        RacingResponse racingResponse = racingGameController.playGame(RacingRequest.of(carNameStringArray, trialNumber));

        printRaceResult(carNameStringArray, trialNumber, racingResponse.getRaceResult());
        printWinner(racingResponse.getWinner());
    }

    private void printWinner(List<String> winner) {
        System.out.print(WINNER_MESSAGE + " : " + String.join(", ", winner));
    }

    private void printRaceResult(String[] carNameStringArray, int trialNumber, Map<String, List<Integer>> raceResult) {
        System.out.println("\n"+Message.EXECUTION_RESULT_MESSAGE);

        for (int i = 0; i < trialNumber; i++) {
            for (String name : carNameStringArray) {
                System.out.print(name + " : ");
                printPlayerResultForRound(i, raceResult.get(name));
                System.out.println("");
            }
            System.out.println("");
        }
    }

    private void printPlayerResultForRound(int round, List<Integer> raceResult) {
        for (int i = 0; i <= round; i++) {
            if (raceResult.contains(i)) {
                System.out.print("-");
            }
        }
    }


    private int getTrialNumberWithInputString() {
        while (true) {
            try {
                System.out.println(TRIAL_INPUT_MESSAGE);
                int trialNumber = Integer.parseInt(scanner.nextLine());
                if (trialNumber < 1)
                    throw new IllegalArgumentException(INVALID_TRIAL_NUMBER_EXCEPTION_MESSAGE.toString());
                return trialNumber;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_TRIAL_NUMBER_EXCEPTION_MESSAGE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getCarListWithInputString() {
        while (true) {
            try {
                System.out.println(CAR_NAME_INPUT_MESSAGE);
                String[] carNameSplitStringArray = scanner.nextLine().split(",");
                if(Arrays.stream(carNameSplitStringArray).anyMatch(s -> s.length() > CAR_NAME_MAX_LENGTH))
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
