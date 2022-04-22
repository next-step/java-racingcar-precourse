package racingcar.model;

import racingcar.view.ResultView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCars extends Cars{
    private Cars winnerCars;

    public RacingCars(){
        super();
    }

    public RacingCars(List<Car> cars){
        super(cars);
    }

    public void registerCars(List<String> carNames){
        for (String name : carNames) {
            addCar(new Car(name));
        }
    }

    public void findWinnerCars() {
        this.winnerCars = new Cars();

        for(Car car : this.cars){
            compareMaxScore(car);
        }
    }

    private void compareMaxScore(Car car) {
        if(car.isWinner()){
            winnerCars.addCar(car);
        }
    }

    public String getWinners() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.winnerCars.cars.size(); i++) {
            sb.append(this.winnerCars.cars.get(i).getName());
            sb.append(getConnectingCode(i));
        }

        return sb.toString();
    }

    private String getConnectingCode(int index) {
        if(index == this.winnerCars.cars.size()-1){
            return "";
        }

        return ", ";
    }

    public void compete() {
        for(Car car : this.cars){
            car.moveCar(pickNumberInRange(Car.MIN_MOVE_NUMBER, Car.MAX_MOVE_NUMBER));
            ResultView.getResultMoveMarkMessage(car.getName(), car.getMoveMark());
        }
    }
}
