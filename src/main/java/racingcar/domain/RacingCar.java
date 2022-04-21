package racingcar.domain;

public class RacingCar {
    private final int FORWARD_MIN_VALUE = 3;

    private CarName name;
    private Distance distance;
    private RaceRecordBoard board;

    public RacingCar(String name, int maxDistance, RaceRecordBoard board) {
        this.name = new CarName(name);
        this.distance = new Distance(maxDistance);
        this.board = board;
    }

    public void move(int move_num){
        if (move_num > FORWARD_MIN_VALUE) {
            distance.increase();
        }

        // 이동 현황판에 이동 기록을 업데이트
        board.updateRecord(name.getName(), distance.getDistance());
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
