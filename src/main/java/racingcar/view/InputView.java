package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String QUESTION_ONE = "1" ;
    private static final String QUESTION_TWO = "2" ;
    private static final String QUESTION_ONE_SENTENCE = "경주할 자동차 이름을 입력하세요." ;
    private static final String QUESTION_TWO_SENTENCE = "시도할 횟수는 몇회인가요?" ;

    public static String askQuestion(String value) {
        if (value.equals(QUESTION_ONE)) {
            System.out.println(QUESTION_ONE_SENTENCE);
        }
        if (value.equals(QUESTION_TWO)) {
            System.out.println(QUESTION_TWO_SENTENCE);
        }
        return Console.readLine();
    }
}
