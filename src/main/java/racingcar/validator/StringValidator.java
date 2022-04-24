package racingcar.validator;

import camp.nextstep.edu.missionutils.Console;

public class StringValidator {

    private String consoleReadline;
    private Integer tryTimes;
    private String[] carNames;

    public Integer getTryTimes() {
        return tryTimes;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public void racingReader() {
        readStringNames();
        carNames = stringSplit(consoleReadline);
        tryTimes = readTryTimes();
    }

    private String readStringNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        consoleReadline = Console.readLine();
        return consoleReadline;
    }

    // TEST를 위한 public 선언
    public Integer readTryTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String strTryTimes = Console.readLine();
        int tryTimes = 0;
        try {
            tryTimes = Integer.parseInt(strTryTimes);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다. ");
            readTryTimes();
        }

        if(tryTimes == 0) {
            System.out.println("[ERROR] 시도 횟수는 0 이상이어야 합니다. ");
            readTryTimes();
        }

        return tryTimes;
    }

    public String[] stringSplit(String consoleString) {
        String[] tempStrList = consoleString.split(",");

        try {
            isWrongName(tempStrList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            racingReader();
        }

        return tempStrList;
    }

    private void isWrongName(String[] tempStrList) {
        for (String str : tempStrList) {
            nameLengthCheck(str);
            nameNullCheck(str);
        }
    }

    private void nameLengthCheck(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이내여야 합니다. ");
        }
    }

    private void nameNullCheck(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다.");
        }

        if (consoleReadline.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다.");
        }
    }
}
