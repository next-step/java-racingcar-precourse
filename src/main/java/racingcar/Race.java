package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class Race {

    private static final String SPLIT_REGEX = ",";
    private final RacingCars racingCars;

    private Race(String names) {
        String[] nameArr = names.split(SPLIT_REGEX);
        RacingCar[] racingCars = new RacingCar[nameArr.length];

        for (int i = 0; i < nameArr.length; i++) {
            racingCars[i] = new RacingCar(nameArr[i]);
        }

        this.racingCars = RacingCars.of(racingCars);

    }

    public static Race from(String names) {
        return new Race(names);
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCars.run();
            racingCars.print();
        }
        printWinners();
    }

    private void printWinners() {
        System.out.printf(PrintMessage.WINNER.getMessage(), racingCars.pickWinners());
    }
}
