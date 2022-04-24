package racingcar;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Cars {

    static final String ERROR_MESSAGE;

    static {
        ERROR_MESSAGE = "[ERROR]";
    }

    public List<Car> cars;

    public Cars(List<Car> cars) {
        validName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validName(List<Car> cars) {
        for (Car car : cars) {
            validNameSize(car);
        }
    }

    private void validNameSize(Car car) {
        if (car.getName().length() > 5 || car.getName().length() == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " IllegalArgumentException");
        }
    }

    public void move() {
        cars.stream()
            .forEach(car -> car.move());
    }

    public void printDistance(String name, int idx) {
        System.out.print(name + " : ");
        for (int i = 0; i < idx; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    public void print() {
        cars.stream()
            .forEach((x) -> printDistance(x.getName(), x.getDistance()));
    }

    public String gerWinner() {
        Optional<Car> car = cars.stream().max((o1, o2) -> o1.getDistance() - o2.getDistance());
        int max = car.get().getDistance();
        String result = "";
        for (Car car1 : cars) {
            result+=getName(car1,max);
        }
        return result.length()==0?"":result.substring(1);
    }

    public String getName(Car car,int max) {
        if(car.getDistance()==max){
            return ","+car.getName();
        }
        return "";
    }

    public static void validInput1(String names) {
        String arr[] = names.split(",");
        if (names.substring(names.length()-1).equals(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " IllegalArgumentException");
        }
        for (String s : arr) {
            if (s.length() > 5 || s.length() == 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }
}
