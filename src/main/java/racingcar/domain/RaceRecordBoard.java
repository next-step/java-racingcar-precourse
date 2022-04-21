package racingcar.domain;

import java.util.HashMap;
import java.util.Optional;

public class RaceRecordBoard {
    private final HashMap<String, Integer> recordBoard;

    public RaceRecordBoard() {
        this.recordBoard = new HashMap<>();
    }

    // 차량 이동 현황 업데이트
    public void updateRecord(String carName, int distance){
        recordBoard.put(carName, distance);
    }

    // 차량 이동 기록 찾기
    public Optional<Integer> findRecord(String carName){
        return Optional.ofNullable(recordBoard.get(carName));
    }

    public void resetRecord(){
        recordBoard.clear();
    }
}
