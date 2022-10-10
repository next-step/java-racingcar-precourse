package racingcar.controller;

import racingcar.model.dto.RoundResult;
import racingcar.model.vo.Entry;
import racingcar.model.vo.TotalRound;
import racingcar.service.RacingServiceImpl;
import racingcar.view.RacingView;

public class RacingController {

    RacingView racingView = new RacingView();
    RacingServiceImpl racingService = new RacingServiceImpl();

    /**
     * 자동차 경주 시작
     */
    public void startRace() {
        Entry entry = getCarEntry();
        TotalRound totalRound = getTotalRound();
        System.out.println("\n실행 결과");
        RoundResult roundResult = proceedRounds(entry, totalRound);
        racingView.raceResultPrint(racingService.getRaceResult(roundResult));
    }

    /**
     * 자동차 목록 확보
     *
     * @return Entry 참가 자동차 목록
     */
    private Entry getCarEntry() {
        Entry entry;
        do {
            entry = racingService.setCarEntry(racingView.carNamesInput());
        } while (entry == null);
        return entry;
    }

    /**
     * 시도 횟수 확보
     *
     * @return TotalRound 시도 횟수
     */
    private TotalRound getTotalRound() {
        TotalRound totalRound;
        do {
            totalRound = racingService.setTotalRound(racingView.totalRoundInput());
        } while (totalRound == null);
        return totalRound;
    }

    /**
     * 입력된 시도횟수만큼 라운드 실행
     *
     * @param entry      참가 자동차 목록
     * @param totalRound 총 시도 횟수
     * @return 경주 진행 결과
     */
    private RoundResult proceedRounds(Entry entry, TotalRound totalRound) {
        RoundResult roundResult = new RoundResult(entry);
        for (int i = 0; i < totalRound.getTotalRound(); i++) {
            racingService.roundProceed(entry, roundResult);
            racingView.roundResultPrint(roundResult);
        }
        return roundResult;
    }
}
