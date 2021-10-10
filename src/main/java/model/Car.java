package model;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Car {

    private final int DEFAULT_NUMBER = 0;
    private final Map< String, Integer > carInfo = new LinkedHashMap< String, Integer>();
    private final List<String> resultList = new ArrayList<String>();
    private final List<String> list = new ArrayList<String>();
    private int racingCount;

    public Map<String, Integer> getCarInfo() {
        return carInfo;
    }

    public void setCarNames(String carNames) {
        for (String str : carNames.split(",")) {
            this.carInfo.put(str, DEFAULT_NUMBER);
            list.add(str);
        }
    }

    public int getRacingCount() {
        return racingCount;
    }

    public void setRacingCount(int racingCount) {
        this.racingCount = racingCount;
    }

    public List<String> getList() {
        return list;
    }

    private String transformToDistance(Integer value){
        String distance = "";
        for( int i = 0; i < value; i++ ){
            distance += "-";
        }
        return distance;
    }

    public void getTentativeResults(){
        Set<Map.Entry<String, Integer>> set = this.carInfo.entrySet();
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while( it.hasNext() ){
            Map.Entry<String, Integer> entry = it.next();
            System.out.println( entry.getKey() + " : " + transformToDistance(entry.getValue()) );
        }
        System.out.println("");
    }

    public void getResult(){

        int maxValue = Collections.max(this.carInfo.values());
        for(Map.Entry<String, Integer> entry : this.carInfo.entrySet()) {
            setWinner(entry, maxValue);
        }
        String winnerStr = StringUtils.join( resultList,"," );
        System.out.println(" 최종 우승자는 " + winnerStr );
    }

    private void setWinner(Map.Entry<String, Integer> entry, int maxValue) {
        if( entry.getValue() == maxValue ) {
            resultList.add(entry.getKey());
        }
    }

    public void clean() {
        carInfo.clear();
        resultList.clear();
        list.clear();
    }
}
