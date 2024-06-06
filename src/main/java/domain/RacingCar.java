package domain;

public class RacingCar {

    private final String name;

    private Long position;

    private RacingCar(String name) {
        this.name = name;
        this.position = 0L;
    }

    public static RacingCar create(RacingCarCommand.Create create) {
        return new RacingCar(create.name());
    }


}
