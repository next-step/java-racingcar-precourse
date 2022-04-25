package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    private int round;
    private List<String> separatedCarnames;

    private static final String INPUT_CARNAME_MESSAGE = "경주 할 자동차이름(이름은쉼표(,)기준으로구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INVALID_CARNAME_LENGTH = "자동차이름은 5글자이하로 작성해주세요.";
    private static final String INVALID_DUPLICATED_CARNAME = "자동차이름은 5글자이하로 작성해주세요.";
    private static final String INVALID_ROUND_TEXT = "숫자만 입력해주세요.";

    private CommandLineInterface(){}

    public static CommandLineInterface getInstance(){
        return new CommandLineInterface();
    }

    public void inputCarNames() {
        this.separatedCarnames = new ArrayList<>();
        System.out.println("call!!!!!!!!!!!");
        try {
            System.out.println(INPUT_CARNAME_MESSAGE);
            String inputText = inputText();
            for (String carname : inputText.split(",")) {
                validationCarname(carname);
                separatedCarnames.add(carname);
            }
            System.out.println(String.join(",", inputText));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(String.format("[ERROR] : %s", e.getMessage()));
            inputCarNames();

        }
    }

    private void validationCarname(String carname) {
        if (carname.length() > 5) {
            throw new IllegalArgumentException(INVALID_CARNAME_LENGTH);
        }
        if ( this.separatedCarnames.contains(carname)){
            throw new IllegalArgumentException(INVALID_DUPLICATED_CARNAME);
        }
    }

    public List<String> getSeparatedCarnames() {
        return separatedCarnames;
    }

    public int getRound() {
        return round;
    }

    public void inputRound() {
        try {
            System.out.println(INPUT_ROUND_MESSAGE);
            round = Integer.parseInt(inputText());
            System.out.println(round);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(String.format("[ERROR] : %s", INVALID_ROUND_TEXT));
            inputRound();
        }
    }

    private String inputText() {
        return Console.readLine();
    }

}
