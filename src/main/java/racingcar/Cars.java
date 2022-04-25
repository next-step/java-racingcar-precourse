package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {

    List<Car> carList;
    private int gameCount;
    public static final int STOP = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    public void addCar(String[] carArray, int gameCount) {
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carArray.length; i++){
            carList.add(new Car(carArray[i],gameCount));
        }
        this.carList = carList;
        this.gameCount = gameCount;
    }

    public String startGame() {
        printingRacing();
        return getWinner();
    }

    public void printingRacing() {
        System.out.println("실행 결과");
        for(int j=0;j<this.gameCount;j++){
            for(int i=0;i<this.carList.size();i++){
                System.out.print(this.carList.get(i).getCarName());
                System.out.print(" : ");
                String temp = this.carList.get(i).getResult() + goAndStop(inputRandomNumber());
                this.carList.get(i).setResult(temp);
                System.out.println(this.carList.get(i).getResult());
            }
            System.out.println();
        }
    }
    public int inputRandomNumber() {
        return pickNumberInRange(MIN_NUM, MAX_NUM);
    }
    public String goAndStop(int randomNumber) {
        if(carCondition(randomNumber)) return "";
        return "-";
    }
    private boolean carCondition(int randomNumber) {
        return randomNumber <= STOP;
    }

    public String getWinner() {
        List<String> list = new ArrayList<>();
        String temp = "";
        for(int i=0; i<carList.size()-1;i++){
            if(this.carList.get(i).getResult().length() > this.carList.get(i+1).getResult().length()){
                list = new ArrayList<>();
                list.add(this.carList.get(i).getCarName());
            }
            if(this.carList.get(i).getResult().length() < this.carList.get(i+1).getResult().length()){
                list = new ArrayList<>();
                list.add(this.carList.get(i+1).getCarName());
            }
            if(this.carList.get(i).getResult().length() == this.carList.get(i+1).getResult().length()){
                if(list.size()==0){
                    list.add(this.carList.get(i).getCarName());
                }
                list.add(this.carList.get(i+1).getCarName());
            }
        }

        for(String item : list){
            temp+=","+item;
        }
        System.out.println("최종 우승자: "+temp.substring(1));
        return "최종 우승자:"+temp.substring(1);
    }
}
