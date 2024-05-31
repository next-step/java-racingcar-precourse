package view;

import domain.CarName;
import util.exception.ProException;
import util.exception.ProMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StartView {
    private static final String CAR_NAMES_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String CAR_NAMES_SEPARATOR = ",";
    public static final String TRY_COUNT_NOTICE = "시도할 회수는 몇회인가요?";

    public List<String> readCarNames() {
        while (true) {
            try {
                ConsoleWriter.printlnMessage(CAR_NAMES_NOTICE);
                return validateCarNames(ConsoleReader.enterMessage());
            } catch (ProException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }

    public int readTryCount() {
        while (true) {
            try {
                ConsoleWriter.printlnMessage(TRY_COUNT_NOTICE);
                return validateNumber(ConsoleReader.enterMessage());
            } catch (ProException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }

    public boolean askToPlayAgain() {
        ConsoleWriter.printlnMessage("게임을 다시 하시겠습니까? (1:새로 시작, 2:종료): ");
        while (true) {
            String input = ConsoleReader.enterMessage().trim();
            try {
                return validatePlayAgainInput(input);
            } catch (ProException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }

    private boolean validatePlayAgainInput(String input) {
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw ProException.from(ProMessage.TRY_NUMBER_ERROR);
    }


    private List<String> validateCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(CAR_NAMES_SEPARATOR)).map(String::trim).filter(name -> !name.isEmpty()).collect(Collectors.toList());

        if (carNames.isEmpty()) {
            throw ProException.from(ProMessage.BLANK_INPUT_ERROR);
        }

        for (String carName : carNames) {
            new CarName(carName); // 유효성 검사를 위해 CarName 객체 생성
        }

        if (hasDuplicatedCarNames(carNames)) {
            throw ProException.from(ProMessage.DUPLICATED_CAR_ERROR);
        }

        return carNames;
    }

    private boolean hasDuplicatedCarNames(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }

    private int validateNumber(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw ProException.from(ProMessage.INVALID_TRY_COUNT_ERROR);
            }
            return count;
        } catch (NumberFormatException e) {
            throw ProException.from(ProMessage.INVALID_TRY_COUNT_ERROR);
        }
    }
}