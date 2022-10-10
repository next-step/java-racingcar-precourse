package racingcar.domain;

import java.util.List;
import java.util.Map;

/**
 * 시도횟수 별 레이싱결과를 표현하는 Map
 */
public class RacingResultsMap {

    private Map<Integer, RacingResults> racingResultsMap;

    public RacingResultsMap(Map<Integer, RacingResults> map) {
        this.racingResultsMap = map;
    }

    public List<String> getWinnerList() {
        return getFinalRacingResults().getWinnerList();
    }

    public RacingResults getFinalRacingResults() {
        int maxTrialNumber = -1;
        for(Integer trialNumber : racingResultsMap.keySet())
            maxTrialNumber = maxTrialNumber > trialNumber ? maxTrialNumber : trialNumber;
        return racingResultsMap.get(maxTrialNumber);
    }


    @Override
    public String toString() {
        String allRacingResult = "";
        for(Integer trialNumber : racingResultsMap.keySet()) {
            allRacingResult += racingResultsMap.get(trialNumber).toString() + "\n";
        }
        return allRacingResult;
    }

}
