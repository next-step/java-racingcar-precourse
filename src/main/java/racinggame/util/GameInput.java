package racinggame.util;

import nextstep.utils.Console;
import racinggame.exception.IllegalInputException;
import racinggame.model.CarSet;

import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class GameInput {
    private static final GameInput gameInput = new GameInput();
    private CarSet carSet = CarSet.getCarSetInstance();
    private Set<String> setForDuplicateCheck;

    private GameInput() {}

    public static GameInput getGameInputInstance() {return gameInput;}

    public ArrayList<String> getInputCarName() {
        ArrayList<String> carNameArray = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            carNameArray.add(stringTokenizer.nextToken());
        }

        return carNameArray;
    }

    public String getInputPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public boolean checkCarName(ArrayList<String> input) {
        int idx ;
        for (idx = 0; idx < input.size() && checkCarNameOneByOne(input.get(idx)); idx++);

        return idx == input.size();
    }

    private boolean checkCarNameOneByOne(String carName) {
        try {
            checkTotal(carName);
        }  catch (Exception e) {
            clearLists();
            System.out.println(e.getMessage());
            return false;
        }
        carSet.addCar(carName);
        return true;
    }

    public boolean checkPlayCount(String playCnt) {
        try {
            isOnlyNum(playCnt);
            isOkScope(Integer.parseInt(playCnt));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void checkTotal(String carName) throws IllegalInputException{
        isOkLength(carName);
        isNotNull(carName);
        isDuplicate(carName);
    }

    // 자동차 이름 길이 제한 검사
    private void isOkLength(String carName) throws IllegalInputException {
        if (carName.length() > Constant.CAR_NAME_LENGTH) {
            throw new IllegalInputException(String.format("[ERROR] 자동차 이름은 %d자리 이하로 입력해주세요.", Constant.CAR_NAME_LENGTH));
        }
    }

    // 자동차 이름이 공백인지 검사
    private void isNotNull(String carName) throws IllegalInputException {
        if (carName.trim().length() == 0) {
            throw new IllegalInputException("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
        }
    }

    // 자동차 이름 중복검사
    private void isDuplicate(String carName) throws IllegalInputException {
        if (setForDuplicateCheck.contains(carName)) {
            setForDuplicateCheck.clear();
            throw new IllegalInputException("[ERROR] " + carName + "이 중복됩니다.");
        }
    }
    // 숫자만 있는지 검사
    private void isOnlyNum(String input) throws IllegalInputException {
        if (!input.matches("[0-9]+")) {
            throw new IllegalInputException("[ERROR] 숫자(자연수) 이외의 문자는 입력할 수 없습니다.");
        }
    }

    // 범위 검사
    private void isOkScope(int input) throws IllegalInputException {
        if (input > Constant.PLAY_COUNT_LIMIT) {
            throw new IllegalInputException(String.format("[ERROR] 최대 %d회까지 플레이할 수 있습니다.", Constant.PLAY_COUNT_LIMIT));
        }
    }

    // 에러 발견 시 자동차 리스트 초기화
    private void clearLists() {
        carSet.clearCarList();
        setForDuplicateCheck.clear();
    }
}
