package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static class RacingCarGameModel {
        HashMap<String, Integer> racers = new HashMap<>();

        String generateWinner(HashMap<String, Integer> racers) {
            int maxValue = 0;
            List<String> winners = new ArrayList<>();

            for (Entry<String, Integer> entry : racers.entrySet()) {
                if (entry.getValue() >= maxValue && entry.getValue() != maxValue) {
                    winners.clear();
                }

                if (entry.getValue() >= maxValue) {
                    maxValue = entry.getValue();
                    winners.add(entry.getKey());
                }
            }
            return String.join(", ", winners);
        }

        private void setCarUsers(String[] racerNames) {
            for (String racer : racerNames) {
                this.racers.put(racer, 0);
            }
        }

        HashMap<String, Integer> run() {
            for (Entry<String, Integer> entry : racers.entrySet()) {
                if (pickNumberInRange(Utils.MIN_NUM, Utils.MAX_NUM) > Utils.PIVOT_VALUE) {
                    racers.put(entry.getKey(), entry.getValue() + 1);
                }
            }
            return racers;
        }
    }

    static class RacingCarGameView {
        private static final String RUN_MARK = "-";

        void printWinner(String winners) {
            System.out.println("최종 우승자: " + winners);
        }

        private String makePosition(int runCount) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < runCount; i++) {
                sb.append(RUN_MARK);
            }
            return sb.toString();
        }

        private void printPosition(HashMap<String, Integer> racers) {
            for (Entry<String, Integer> entry : racers.entrySet()) {
                System.out.println(entry.getKey() + " : " + makePosition(entry.getValue()));
            }
            System.out.println();
        }

        boolean validateCarName(String input) {
            String[] carNames = Utils.isContainComma(input);

            Utils.checkCarNameLength(carNames);
            Utils.checkDuplicateCarName(carNames);

            return true;
        }

        private int askTryCount() {
            System.out.println("시도할 회수");

            boolean result = false;
            String strNum = "";

            do {
                try {
                    result = Utils.isNumber(strNum = readLine());
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            } while (!result);

            return Integer.parseInt(strNum);
        }

        private String[] askCarName() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요.)");

            boolean result = false;
            String input = "";

            do {
                try {
                    result = validateCarName(input = readLine());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!result);

            return input.split(",");
        }
    }

    static class RacingCarGameController {
        private final RacingCarGameView racingCarGameView = new RacingCarGameView();
        private final RacingCarGameModel racingCarGameModel = new RacingCarGameModel();

        private void start() {
            String[] carNames = racingCarGameView.askCarName();
            int tryCount = racingCarGameView.askTryCount();
            HashMap<String, Integer> result = null;

            racingCarGameModel.setCarUsers(carNames);

            for (int i = 0; i < tryCount; i++) {
                racingCarGameView.printPosition(result = racingCarGameModel.run());
            }

            racingCarGameView.printWinner(racingCarGameModel.generateWinner(result));
        }
    }

    static class Utils {
        private static final int MIN_NUM = 0;
        private static final int MAX_NUM = 9;
        private static final int PIVOT_VALUE = 3;

        static void checkDuplicateCarName(String[] carName) {
            Set<String> carNameSet = new HashSet<>(Arrays.asList(carName));

            if (carNameSet.size() != carName.length) {
                throw new IllegalArgumentException("[ERROR] 입력된 자동차 이름에 중복이 있습니다.");
            }
        }

        static void checkCarNameLength(String[] carNames) {
            for (String carName : carNames) {
                if (carName.length() == 0 || carName.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하입니다.");
                }
            }
        }

        static String[] isContainComma(String carNames) {
            if (!carNames.contains(",")) {
                throw new IllegalArgumentException("[ERROR] 사용자 구분을 위한 (,) 입력이 생략되었습니다.");
            }
            return carNames.split(",");
        }

        static boolean isNumber(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("[ERROR] 입력된 값은 숫자가 아닙니다.");
            }
        }
    }

    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController();
        racingCarGameController.start();
    }
}
