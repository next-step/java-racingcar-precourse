package racingcar.domain.race;

public class RaceTime {
    public static final String RACE_TIME_ERROR = "[ERROR] 경주 할 횟수는 양의 정수입니다. ";
    private final int raceTime;

    private RaceTime(int raceTime) {
        this.raceTime = raceTime;
    }

    private RaceTime(String raceTime) {
        this.raceTime = ValidateRaceCount(raceTime);
    }

    /**
     * RaceTime 생성자
     *
     * @param raceTime 경주 회수 입력값
     * @return 경주 회수
     */
    static public RaceTime of(String raceTime) {
        return new RaceTime(raceTime);
    }


    /**
     * validation check
     *
     * @param raceTime 입력값
     * @return 양의 정수
     */
    private int ValidateRaceCount(String raceTime) {
        int count;
        try {
            count = Integer.parseInt(raceTime);
        } catch (Exception e) {
            throw new IllegalArgumentException(RACE_TIME_ERROR);
        }
        if (count <= 0) throw new IllegalArgumentException(RACE_TIME_ERROR);

        return count;
    }

    public boolean isLast(int index) {
        return raceTime == index;
    }
}
