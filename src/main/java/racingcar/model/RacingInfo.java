package racingcar.model;

import racingcar.exception.UserInputException;
import racingcar.util.Util;
import racingcar.view.RacingGameUi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RacingInfo {
    private List<Car> carList = new ArrayList();
    private int laps = 0;
    private RacingStatus status = RacingStatus.WAIT;

    public RacingInfo(){
        status.waitRacing();
    }

    public void setCarList(String nameList){
        carList.clear();
        for(String name : nameList.split(Message.SPLIT))
            carList.add(new Car(name));
    }

    public void setLaps(String cnt){
        try{
            laps = Integer.parseInt(cnt);
        }catch(NumberFormatException e){
            throw new UserInputException(Message.ERROR_LAPS_ONLY_DIGIT);
        }

        if(laps <= 0)
            throw new UserInputException(Message.ERROR_LAPS_NOT_NEGATIVE);
    }

    public void racing(){
        status.startRacing();

        for(Car c : carList){
            c.move();
            c.printPosition();
        }
        RacingGameUi.printEmptyLine();

        if(--laps <= 0) status.endRacing();
    }

    public boolean isEnd() {
        return status.isEnd();
    }

    public String getHeadCarName() {
        Map<Integer, String> rankMap = new TreeMap();
        int winnerPos = 0;
        for(Car c : carList){
            String preName = Util.string.nvl(rankMap.get(c.getPos()));
            rankMap.put(c.getPos(), preName + Message.SPLIT + c.getName());
            winnerPos = Math.max(winnerPos, c.getPos());
        }

        //맨 앞은 split 문자가 들어가기 때문에 처음 문자를 제거한다.
        return rankMap.get(winnerPos).substring(1);
    }
}
