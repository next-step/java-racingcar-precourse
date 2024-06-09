package Service;

import Model.Car;
import Utils.RandomUtil;
import Utils.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingServiceImpl implements RacingService {

    private static RacingService instance = new RacingServiceImpl();

    private RacingServiceImpl() {}
    public static RacingService getInstance() {
        return instance;
    }

    private List<Car> cars;
    private int time;

    @Override
    public void setRace(String names, String time) throws IllegalArgumentException {
        cars = new ArrayList<>();
        // 자동차 이름 정보를 바탕으로 자동차 배열 생성
        for (String name : names.split(",")){
            cars.add(new Car(name));
        }
        try{
            this.time = Integer.parseInt(time);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(SystemMessage.NOT_A_NUMBER);
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < time; i++) {
            playOneRound();
            printOneRound();
        }
    }

    private void printOneRound() {
        for(Car car : cars){
            System.out.println(car);
        }
        System.out.println();
    }

    private void playOneRound() {
        int[] randArr = RandomUtil.getRandomArray(cars.size(), 0, 9);
        for (int j = 0; j < cars.size(); j++) {
            if(randArr[j] >= 4){
                cars.get(j).incCnt();
            }
        }
    }

    @Override
    public List<String> getResult() {
        List<String> res = new ArrayList<>();
        int max = -1;
        res = getChampoions(max, res);
        return res;
    }

    private List<String> getChampoions(int max, List<String> res) {
        for (Car car : cars) {
            if(car.getCnt() > max){
                max = car.getCnt();
                res = new ArrayList<>();
                res.add(car.getName());
            }
            else if(car.getCnt() == max){
                res.add(car.getName());
            }
        }
        return res;
    }


}
