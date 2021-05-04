import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public CarList(ArrayList<Car> list) {
        this.carList = list;
    }

    public int size() {
        return carList.size();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public void doStep() {
        for (Car car : carList) {
            car.go();
        }
    }

    public String toString() {
        String result = "";
        for (Car car : carList) {
            result += car.toString() + "\n";
        }
        result += "\n";
        return result;
    }

}
