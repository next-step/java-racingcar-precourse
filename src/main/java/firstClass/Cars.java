package firstClass;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List< Car > cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    };

    public void randomMoveCars( int tryCount ){
        for(int i = 0; i < tryCount; i ++){
            moveCar(cars);
            System.out.printf("\n");
        }
    }

    private void moveCar(List<Car> cars){
        for(Car car : cars){
            car.goAhead();
            System.out.println(car.myTotalDistance());
        }
    }

    public void showWinner(int tryCount){
        List<String> winner = new ArrayList<>();
        for(Car car : cars){
            this.setWinner( car, winner, car.maxMoved(), tryCount);
        }

        String winners = String.join( ", ", winner );
        if(winner.size() == 0){
            winners = "없습니다";
        }
        System.out.println("최종 우승자: " + winners );
    }

    private void setWinner(Car car, List<String> winner, int maxMoved, int tryCount){
        if(maxMoved == tryCount){
            winner.add( car.myName() );
        }
    }
}
