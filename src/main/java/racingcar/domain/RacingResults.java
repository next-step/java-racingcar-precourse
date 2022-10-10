package racingcar.domain;

import java.util.*;

public class RacingResults {

    List<RacingResult> racingResults;

    public RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
    }

    public List<String> getWinnerList() {
        TreeMap<Integer,List<String>> positionNameMap = new TreeMap<>();
        for(RacingResult racingResult : racingResults) {
            List<String> carNameList = positionNameMap.getOrDefault(racingResult.getPosition(),new ArrayList<>());
            carNameList.add(racingResult.getCarName());
            positionNameMap.put(racingResult.getPosition(),carNameList);
        }
        return positionNameMap.get(positionNameMap.lastKey());
    }

    public RacingResult getByCarName(String name) {
        Map<String, RacingResult> map = new HashMap<>();
        for(RacingResult racingResult : racingResults) {
            map.put(racingResult.getCarName(), racingResult);
        }
        return map.get(name);
    }

    public RacingResults copyOf() {
        List<RacingResult> copyList = new ArrayList<>();
        for(RacingResult racingResult : racingResults) {
            copyList.add(racingResult.deepCopyOf());
        }
        return new RacingResults(copyList);
    }

    @Override
    public String toString() {
        String printingResults = "";
        for(RacingResult racingResult : racingResults) {
            printingResults += (racingResult.toString());
        }
        return printingResults;
    }

}
