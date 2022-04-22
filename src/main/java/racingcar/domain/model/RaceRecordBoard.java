package racingcar.domain.model;

import racingcar.domain.dto.RacingCarDto;

import java.util.*;

public class RaceRecordBoard {
    private final HashMap<String, Integer> recordBoard;

    public RaceRecordBoard() {
        this.recordBoard = new HashMap<>();
    }

    /**
     * 차량 이동 현황 업데이트
     */
    public void updateRecord(String carName, int distance) {
        recordBoard.put(carName, distance);
    }

    /**
     * 차량 이동 기록 찾기
     */
    public Optional<Integer> findRecord(String carName) {
        return Optional.ofNullable(recordBoard.get(carName));
    }

    /**
     * 우승자 리스트 찾기
     */
    public List<RacingCarDto> findWinners() {
        List<RacingCarDto> winnerList = new ArrayList<>();
        Integer maxDistance = Collections.max(recordBoard.values());

        recordBoard.forEach((key, value) -> {
            if (value == maxDistance.intValue())
                winnerList.add(new RacingCarDto(key, value));
        });
        return winnerList;
    }

    public void resetRecord() {
        recordBoard.clear();
    }
}
