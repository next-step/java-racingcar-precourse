package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.CarEntity;

import java.util.ArrayList;

public class RacingcarModel {
    private RacingCarList carList;
    private int mMaxposition = 0;

    private final int MOVE_LEN = 1;
    private final int MAX_STOP_NUM = 3;

    public RacingcarModel() {
        carList = new RacingCarList();
    }

    public boolean addCar(String carName) {
        carList.addCar(new CarEntity(carName));
        return true;
    }

    public int getCarLen() {
        return carList.getCarCount();
    }

    private boolean isMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n <= MAX_STOP_NUM) {
            return false;
        }
        return true;
    }

    public boolean runCarOnce() {
        for (int i = 0; i < getCarLen(); i++) {
            if (isMove()) {
                CarEntity car = carList.getCarEntity(i);
                car.moveCar(MOVE_LEN);
                checkMaxPosition(car);
            }
        }
        return true;
    }

    private void checkMaxPosition(CarEntity car) {
        int carPosition = car.getPosition();
        if (carPosition > mMaxposition) {
            mMaxposition = carPosition;
        }
    }


    public void printCarPosition() {
        for (int i = 0; i < getCarLen(); i++) {
            CarEntity car = carList.getCarEntity(i);
            String dashStr = "";
            for (int j = 0; j < car.getPosition(); j++)
                dashStr += "-";
            System.out.println(car.getName() + " : " + dashStr);
        }
    }

    public String getForefrontCarName() {
        ArrayList<String> forefrontCarList = new ArrayList<>();
        int carPosition;
        for (int i = 0; i < getCarLen(); i++) {
            CarEntity car = carList.getCarEntity(i);
            carPosition = car.getPosition();
            if (carPosition == mMaxposition)
                forefrontCarList.add(car.getName());
        }
        return convertArraylistToString(forefrontCarList);
    }

    private String convertArraylistToString(ArrayList<String> list) {
        String res = "";
        for (String name : list) {
            if (res.equals("")) {
                res += name;
                continue;
            }
            res += ", " + name;
        }
        return res;
    }

    public boolean inputCarFromString(String carNameList) {
        String nameArr[] = carNameList.split(",");

        for (String name : nameArr) {
            try {
                addCar(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                carList.clearCarList();
                return false;
            }

        }
        return true;
    }
}
