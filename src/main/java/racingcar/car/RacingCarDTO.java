package racingcar.car;

public class RacingCarDTO {
    private final String name;
    private final int position;

    public RacingCarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarDTO of(RacingCar racingCar) {
        return new RacingCarDTO(
                racingCar.getRacingCarName().getName(),
                racingCar.getRacingCarPosition().getPosition()
        );
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
