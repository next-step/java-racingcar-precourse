package racingcar.service;

import racingcar.model.dto.EnteredCarNames;
import racingcar.model.dto.RaceResult;
import racingcar.model.dto.RoundResult;
import racingcar.model.vo.Entry;
import racingcar.model.vo.TotalRound;

public interface RacingService {

    /**
     * 참가 자동차 목록 세팅
     *
     * @param carNamesInput 입력받은 자동차 이름들
     * @return 자동차 목록
     */
    Entry setCarEntry(EnteredCarNames carNamesInput);

    /**
     * 총 시도 횟수 세팅
     *
     * @param totalRoundInput 입력받은 시도횟수
     * @return 총 시도 횟수
     */
    TotalRound setTotalRound(String totalRoundInput);

    /**
     * 자동차 경주 1회 실행
     *
     * @param entry       자동차 목록
     * @param roundResult 현재까지 경주 진행한 결과
     */
    void roundProceed(Entry entry, RoundResult roundResult);

    /**
     * 최종 우승자 목록 확보
     *
     * @param roundResult 현재까지 경주 진행한 결과
     * @return 우승자 목록
     */
    RaceResult getRaceResult(RoundResult roundResult);
}
