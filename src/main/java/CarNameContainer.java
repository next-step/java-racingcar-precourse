import java.util.ArrayList;
import java.util.List;

public class CarNameContainer {
    private List<CarName> carNames;

    public CarNameContainer(String[] carNameStrings){
        this.carNames = new ArrayList<>();

        for (String carNameString : carNameStrings) {
            this.carNames.add(new CarName(carNameString));
        }
    }

    public int size(){
        return this.carNames.size();
    }
}
