package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Car;
import model.CarList;

public class RacingService {
    private Random random ;
    public RacingService(){
        random = new Random();
    }
    private int getRandomNum(){
        return random.nextInt(10);
    }

    public void race(CarList carList){
        // 랜덤 값 나와서 전진하는 로직
        for(Car car : carList.getCarList()) {
            int randNum = getRandomNum();
            if(randNum >= 4){
                car.move();
            }
        }
    }

    public int getMaxDistance(CarList carList){
        int maxDistance = 0;
        for( Car car : carList.getCarList()){
            if(maxDistance < car.getDistance()){
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }


    public List<String> getWinner(int maxDistance, CarList carList){
        List<String> winner = new ArrayList<>();
        for( Car car : carList.getCarList()){
            if(car.getDistance() == maxDistance){
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
