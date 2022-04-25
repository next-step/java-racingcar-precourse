package racingcar.domain.model;

public class Distance {
    private int distance;            // 이동한 거리
    private final int LIMIT;         // 이동 가능한 최대 거리
    private final int MOVE_UNIT = 1; // 이동 단위

    public Distance(int limit) {
        this.LIMIT = limit;
        this.distance = 0;
    }

    /**
     * 거리 증가 시키기
     */
    public void increase() {
        if (isPossible())
            distance += MOVE_UNIT;
    }

    /**
     * 거리 증가가 가능한지 판단
     */
    private boolean isPossible() {
        return distance < LIMIT;
    }

    public Integer getDistance(){
        return this.distance;
    }

    public Integer getLimit(){ return LIMIT; }
}
