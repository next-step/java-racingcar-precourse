package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Cars {
    private List<Car> cars;

    public List<Car> carsList() {
        return new ArrayList<>(this.cars);
    }

}
