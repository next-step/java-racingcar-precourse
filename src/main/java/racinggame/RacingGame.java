package racinggame;

import nextstep.utils.Randoms;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;
    private List<Car> cars = new ArrayList<Car>();
    private int cnt;

    public RacingGame(String cars){
        setCars(cars);
    }

    public void setCars(String cars){
        String[] arr = cars.split(",");
        for(String item : arr){
            Car car = new Car(item);
            this.cars.add(car);
        }
    }

    public void setTryCnt(int cnt){
        this.cnt = cnt;
    }

    public void run(){
        for(int i=0;i<cnt;i++){
            moveCars();
            System.out.println();
        }
    }
    private void moveCars(){
        for(int i=0;i<cars.size();i++){
            cars.get(i).play(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
            OutputView.displayCar(cars.get(i));
        }
    }
}
