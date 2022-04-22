package racingcar.domain.model;

public class RacingCar {
    private final int FORWARD_MIN_VALUE = 3; // 전진 가능한 최소 값
    private final CarName name;
    private final Distance distance;
    private final RaceRecordBoard board;

    public RacingCar(String name, Distance distance, RaceRecordBoard board) {
        this.name = new CarName(name);
        this.distance = distance;
        this.board = board;
    }

    /**
     * 차량 전진
     */
    public void move(int n) {
        if (n > FORWARD_MIN_VALUE) {
            distance.increase();
        }
        // RaceRecordBoard 객체에 이동 기록을 업데이트
        board.updateRecord(name.getName(), distance.getDistance());
    }

    public String getName() {
        return name.getName();
    }

    public Integer getDistance() {
        return distance.getDistance();
    }

    public Integer getTryLimit() {
        return distance.getLimit();
    }
}
