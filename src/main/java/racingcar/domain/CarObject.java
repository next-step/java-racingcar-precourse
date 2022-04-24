package racingcar.domain;

/**
 * currentRoundNumber 현재 회차 랜덤 숫자
 * forwardCount 전진 횟수 누적 카운트
 */
public class CarObject implements Comparable<CarObject>{
    private Integer currentRoundNumber;
    private Integer forwardCount;
    private String carName;

    public CarObject(String carName){
        this.carName = carName.trim();
        this.forwardCount = 0;
        this.currentRoundNumber = -1;
    }
    public CarObject(CarObject other){
        this.carName = other.getCarName();
        this.forwardCount = other.getForwardCount();
        this.currentRoundNumber = other.getCurrentRoundNumber();
    }

    public Integer getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public String getCarName() {
        return carName;
    }

    public void setCurrentRoundNumber(Integer currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * 현재 객체와 비교할 대상 객체를 비교
     * @param other
     * @return 내림차순
     */
    @Override
    public int compareTo(CarObject other) {
        return other.getForwardCount() - this.forwardCount;
    }

    @Override
    public String toString() {
        return carName + " : "+getMovementBars();
    }

    /**
     * 해당 차량의 현재 진행상황을 요구사항에 맞추어 리턴
     * @return -
     */
    private String getMovementBars(){
        String result = "";
        for(Integer i =0 ; i< this.forwardCount ; i++){
            result += "-";
        }
        return result;
    }
}
