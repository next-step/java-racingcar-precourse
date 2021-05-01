import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInputParser {
    public List<CarName> parse(String userInput) {
        String[] carNameStrings = userInput.split(",");

        return this.createCarNames(carNameStrings);
    }

    private List<CarName> createCarNames(String[] carNameStrings){
        List<CarName> carNames = new ArrayList<>();

        for (String carNameString : carNameStrings) {
            Optional<CarName> mayCarName = this.getCarName(carNameString);

            this.tryInsert(mayCarName, carNames);
        }

        return carNames;
    }

    private Optional<CarName> getCarName(String carNameString) {
        CarName carname = null;

        try {
            carname = new CarName(carNameString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return Optional.ofNullable(carname);
    }

    private void tryInsert(Optional<CarName> mayContent, List<CarName> container) {
        if (mayContent.isPresent()) {
            container.add(mayContent.get());
        }
    }
}
