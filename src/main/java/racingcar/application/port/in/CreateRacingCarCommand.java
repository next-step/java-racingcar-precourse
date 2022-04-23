package racingcar.application.port.in;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCarNames;
import racingcar.util.RacingCarNameCheck;
import racingcar.util.SelfValidating;

public class CreateRacingCarCommand extends SelfValidating<CreateRacingCarCommand> {

    @RacingCarNameCheck
    private final String input;

    public CreateRacingCarCommand(String input) {
        this.input = input;
        super.validateSelf();
    }

    public RacingCarNames getRacingCarNames() {
        String[] splitInput = input.split(",");
        List<RacingCarName> carNameList = new ArrayList<>();

        for (String name : splitInput) {
            carNameList.add(new RacingCarName(name));
        }

        return new RacingCarNames(carNameList);
    }
}
