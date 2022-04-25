package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public void start(Car car) {
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        car.paddock(Console.readLine());
        moving(car.track);
    }

    private void moving(Map<String, Integer> track) {
        System.out.println("시도할 회수는 몇회인가요?");
        int times = howManyTimes(Console.readLine());

        List<Entry<String, Integer>> list = new ArrayList<>(track.entrySet());
        for (int i = 0; i < times; i++) {
            for (Entry<String, Integer> stringIntegerEntry : list) {
                int value = stringIntegerEntry.getValue();
                value = value + moveOrStop();
                System.out.println(stringIntegerEntry.getKey() + " : " + hyphen(value));
                track.put(stringIntegerEntry.getKey(), value);
            }
        }
        list.sort(Entry.comparingByValue());
        iniminimanimo(list);
    }

    private int howManyTimes(String number) {
        return Integer.parseInt(number);
    }

    private int moveOrStop() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= MOVING_FORWARD) {
            return 1;
        }
        return 0;
    }

    public String hyphen(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append("-");
        }
        return result.toString();
    }

    private void iniminimanimo(List<Entry<String, Integer>> list) {
        List<Entry<String, Integer>> winners = list.stream()
                .filter(x -> Objects.equals(list.get(list.size() - 1).getValue(), x.getValue()))
                .collect(Collectors.toList());
        if (winners.size() > 1) {
            StringBuilder winner = new StringBuilder();
            for (int n = 0; n < winners.size(); n++) {
                winner.append(winners.get(n).getKey());
                if (winners.size() - 1 != n) {
                    winner.append(",");
                }
            }
            System.out.println("공동 우승자: " + winner);
        }
        if (winners.size() == 1) {
            System.out.println("최종 우승자: " + winners.stream().findFirst().get().getKey());
        }
    }
}
