package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Data{
    public List<String> carNameList;
    int tryCount = 0;

    public void inItCarNameList(){
        this.carNameList = new ArrayList<>();
    }

    public void setCarNameList(List<String> carNameList){
        this.carNameList = carNameList;
    }

    public List<String> getCarNameList(){
        return this.carNameList;
    }

    public void inItTryCount(){
        this.tryCount = 0;
    }

    public void setTryCount(int tryCount){
        this.tryCount = tryCount;
    }

    public int getTryCount(){
        return this.tryCount;
    }
}
