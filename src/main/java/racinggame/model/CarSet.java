package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.exception.IllegalInputException;
import racinggame.util.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarSet {
    private static final CarSet carSet = new CarSet();
    private ArrayList<Car> cars;
    private Set<String> setForDuplicateCheck;

    private CarSet() {
        this.cars = new ArrayList<>();
        this.setForDuplicateCheck = new HashSet<>();
    }

    public static CarSet getCarSetInstance() {
        return carSet;
    }

    public boolean addCar(String name) {
        try {
            isDuplicate(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        setForDuplicateCheck.add(name);
        cars.add(new Car(name));
        return true;
    }

    private void isDuplicate(String name) throws IllegalInputException {
        if (setForDuplicateCheck.contains(name)) {
            cars.clear();
            setForDuplicateCheck.clear();
            throw new IllegalInputException("[ERROR] " + name + "이 중복됩니다.");
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            moveCarOneByOne(i, Randoms.pickNumberInRange(Constant.LOWER_BOUND_OF_MOVE_POSSIBILITY, Constant.UPPER_BOUND_OF_MOVE_POSSIBILITY));
        }
    }

    private void moveCarOneByOne(int idx, int possibility) {
        if (possibility >= Constant.BORDER_OF_MOVE_POSSIBILITY) cars.get(idx).moveForward();
    }
}
