package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceRecord {
    public static final String RACE_RESULT = "실행 결과";
    public static final String RACE_PROGRESS_MARKER = "-";
    public static final String RACE_PROGRESS_FORM = "%s : %s";
    public static final String RACE_WINNER_FORM = "최종 우승자: %s";
    public static final String RACE_WINNER_DIVIDER = ", ";
    public static final String LINE_BREAK = "";

    private List<String> records;

    public RaceRecord() {
        records = new ArrayList<>();
        records.add(RACE_RESULT);
    }

    public void of(LinkedHashMap<String, Car> cars) {
        for(Car car : cars.values()) {
            addRaceProgressOf(car);
        }
        addLineBreak();
    }

    public List<String> getList() {
        return records;
    }

    private void addLineBreak() {
        records.add(LINE_BREAK);
    }

    private void addRaceProgressOf(Car car) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            sb.append(RACE_PROGRESS_MARKER);
        }
        records.add(String.format(RACE_PROGRESS_FORM, car.getName(), sb));
    }

    public void addWinners(Winners winners) {
        records.add(
                String.format(RACE_WINNER_FORM, String.join(RACE_WINNER_DIVIDER,winners.getWinnerList()))
        );
    }

    @Override
    public String toString() {
        return String.join("\n", records);
    }
}
