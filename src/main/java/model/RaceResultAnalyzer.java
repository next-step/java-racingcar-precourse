package model;

/*
랜덤에서 저장된 자료를 기반으로 각 자동차별 value의 길이를 비교 후
우승자를 Return
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RaceResultAnalyzer {

    public Set<String> compareRaceCar(HashMap<String, String> result) {
        int maxdistance = 0;
        Set<String> winner_list = new HashSet<>();
        for(Map.Entry<String,String> entry : result.entrySet()) {
            if(entry.getValue().length() > maxdistance) {
                winner_list.clear();
                maxdistance = entry.getValue().length();
                winner_list.add(entry.getKey());
            }
            if(entry.getValue().length() == maxdistance)
                winner_list.add(entry.getKey());
        }

        return winner_list;
    }


}
