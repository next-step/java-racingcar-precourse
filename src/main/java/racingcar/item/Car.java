package racingcar.item;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 8:40 PM
 */
public class Car {

    private String name;

    private String result = "";

    private Map<Integer, CarStatus> status = new HashMap<>();

    public Car(String name, int input) {
        this.name = name;
        for (int i = 0; i < input; i++) {
            CarStatus carStatus = carStatusSetting();

            this.status.put(i, carStatus);

            if (carStatus == CarStatus.GO) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(result).append("-");
                result = stringBuilder.toString();
            }
        }

    }

    private CarStatus carStatusSetting() {
        if (pickNumberInRange(0, 9) >= 4) {
            return CarStatus.GO;
        }
        return CarStatus.STOP;
    }

    public int CountGoStatus() {
        int count = 0;

        for (CarStatus value : status.values()) {
            if (value == CarStatus.GO) {
                count++;
            }
        }

        return count;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, CarStatus> getStatus() {
        return status;
    }
}
