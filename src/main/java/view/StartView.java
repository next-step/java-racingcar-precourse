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
            } catch (ProException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }

    public int readTryCount() {
        while (true) {
            try {
                ConsoleWriter.printlnMessage(TRY_COUNT_NOTICE);
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

}