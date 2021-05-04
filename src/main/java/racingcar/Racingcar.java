package racingcar;

import utils.ValidationUtils;

import java.util.*;

public class Racingcar {
    private Scanner scanner = new Scanner(System.in);
    private List<String> carNameList = new ArrayList<>();
    private HashMap<String, Integer> carMap;

    public void run() {
        inputCarNames();
        inputRaceNum();

        System.out.println("시도할 횟수는 몇회인가요?");
        final int tryNum = Integer.parseInt(scanner.nextLine());

        System.out.println("실행결과 :");
        for (int i = 0; i < tryNum; i++) {
            racing();
        }
        System.out.println(winner(carNameList) + "가 최종 우승했습니다.");
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameList = Cars.carNamesToList(scanner.nextLine());

        carMap = new HashMap<>();

        for (String carName : carNameList) {
            carMap.put(carName, 0);
        }

        List<String> compareList = new ArrayList<>(carMap.keySet());
        ValidationUtils.duplicateCarName(carNameList, compareList);
    }

    private void inputRaceNum() {
    }

    private void racing() {
        Random random = new Random();
        int flagNum;
        for (String carName : carNameList) {
            flagNum = random.nextInt(10);
            setRaceNum(carName, flagNum);
            System.out.println(carName + ":" + visualDistance(carMap.get(carName)));
        }
        System.out.println();
    }

    public String visualDistance(int moveCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void setRaceNum(String carName, int flagNum) {
        if (flagNum > 4) {
            carMap.put(carName, carMap.get(carName) + 1);
        }
    }

    public String winner(List<String> carNameList) {
        StringBuilder stringBuilder = new StringBuilder();

        Collections.sort(carNameList, (object1, object2) -> (carMap.get(object2).compareTo(carMap.get(object1))));

        for (String carName : carNameList) {
            if (carMap.get(carName).equals(carMap.get(carNameList.get(0)))) {
                stringBuilder.append(", ").append(carName);
            }
        }

        return stringBuilder.substring(2);
    }
}
