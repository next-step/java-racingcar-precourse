package racingcar.model.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.car.CarName;

public class UserInputCarNames {

    private final List<CarName> carNameList = new ArrayList<>();

    public UserInputCarNames(List<String> nameList) {
        validateSize(nameList);
        validateDuplicate(nameList);
        for (String carName : nameList) {
            carNameList.add(new CarName(carName));
        }
    }

    private void validateDuplicate(List<String> carNameList) {
        Set<String> nonDuplicateCarNames = new HashSet<>(carNameList);
        if (nonDuplicateCarNames.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 이름을 가진 자동차를 설정할 수 없습니다.");
        }
    }

    private void validateSize(List<String> carNameList) {
        if (carNameList.size() == 0) {
            throw new IllegalArgumentException("1개 이상의 자동차 이름이 필요합니다.");
        }
    }

    public List<CarName> getCarNameList() {
        return carNameList;
    }

}
