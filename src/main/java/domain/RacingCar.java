package domain;

import java.util.List;

public class RacingCar {

    private final String name;

    private Long position;

    private RacingCar(String name) {
        this.name = name;
        this.position = 0L;
    }

    public static List<RacingCar> create(RacingCarCommand.Create create) {
        return create.name().stream()
            .map(RacingCar::new)
            .toList();
    }


}
