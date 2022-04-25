package racingcar.domain.model;

public class RacingCar implements Vehicle<Integer> {
    private final int FORWARD_MIN_VALUE = 3; // 전진 가능한 최소 값
    private final Name name;
    private final Distance distance;
    private final RecordBoard<String, Integer> recordBoard;

    public RacingCar(Name name, Distance distance, RecordBoard<String, Integer> recordBoard) {
        this.name = name;
        this.distance = distance;
        this.recordBoard = recordBoard;
    }

    /**
     * 차량 전진
     */
    @Override
    public void move(Integer n) {
        if (n > FORWARD_MIN_VALUE) {
            distance.increase();
            recordBoard.updateRecord(name.getName(), distance.getDistance());
        }
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public Integer getDistance() {
        return distance.getDistance();
    }

    @Override
    public Integer getTryLimit() {
        return distance.getLimit();
    }
}
