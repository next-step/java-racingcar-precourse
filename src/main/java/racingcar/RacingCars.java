package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCars {

    private final List<RacingCar> racingCars;

    private RacingCars(RacingCar... racingCars) {
        this.racingCars = Arrays.asList(racingCars);
    }

    public static RacingCars of(RacingCar... racingCars) {
        return new RacingCars(racingCars);
    }

    public String pickWinners() {
        List<RacingCar> winners = getWinners();
        return getNames(winners);
    }

    private List<RacingCar> getWinners() {
        List<RacingCar> list = new ArrayList<>(this.racingCars);
        list.sort(Comparator.reverseOrder());
        RacingCar winner = list.get(0);

        List<RacingCar> winnerList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            addWinnerList(winner, list.get(i), winnerList);
        }

        return winnerList;
    }

    private void addWinnerList(RacingCar winner, RacingCar other, List<RacingCar> winnerList) {
        if (isTie(winner, other)) {
            winnerList.add(other);
        }
    }

    private boolean isTie(RacingCar o1, RacingCar o2) {
        return o1.equals(o2);
    }

    private String getNames(List<RacingCar> racingCars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            sb.append(", ");
            sb.append(racingCar.getName());
        }

        return sb.substring(2);
    }

    public void print() {
        for (RacingCar racingCar : racingCars) {
            racingCar.print();
            System.out.println();
        }
        System.out.println();
    }

    public void run() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RacingCarRandomNumberGenerator.generate());
        }
    }


}
