package racinggame.domain.game;

import racinggame.domain.cars.Car;
import racinggame.domain.constants.Delimters;
import racinggame.domain.constants.Messages;
import racinggame.domain.users.User;
import racinggame.domain.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private final User user;
    private int round;
    private ArrayList<Car> cars = new ArrayList();

    public Game(User user) {
        this.user = user;

    }

    public void init(int round, String[] carNames) {
        this.round = round;
        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            cars.add(car);
        }
    }

    public void play() {
        System.out.println(Delimters.EMPTY);
        System.out.println(Messages.RESULT.getMessage());
        for (int i = 0; i < this.round; i++) {
            racingCars();
            System.out.println(Delimters.EMPTY);
        }
        System.out.println(judgeWinner());

    }

    private void racingCars() {
        for (Car car : cars) {
            int random = car.getRandomValueBetweenOneAndNine();
            System.out.println(car.judgeToStopOrForward(random));
        }
    }

    public int userInputRound() {
        try {
            String input = user.readInput(Messages.INPUT_GAME_COUNT);
            if (!ValidationUtils.validGameRound(input)) {
                System.out.println(Messages.INPUT_ERROR.getMessage());
                throw new NumberFormatException("For input string: " + input);
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return userInputRound();
        }
    }

    public String[] userInputCarNames() {
        String input = user.readInput(Messages.INPUT);
        if (!ValidationUtils.validSplitableCarNames(input)) {
            System.out.println(Messages.INPUT_ERROR.getMessage());
            return userInputCarNames();
        }
        return input.split(Delimters.COMMA);
    }

    public ArrayList<Car> getCars() {  //테스트 코드를 위한 메서드
        return cars;
    }

    private String judgeWinner() {
        ArrayList<Integer> compareArray = setCompareArray();
        int winners = getHowManyWinners(compareArray);
        return outputWinner(winners);
    }

    private String outputWinner(int winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.COMPLETE_FIRST_SENTENCE.getMessage());
        for (int i = 0; i < winners; i++) {
            sb.append(cars.get(i).getName());
            if (i != winners - 1) sb.append(Delimters.COMMA);
        }
        sb.append(Messages.COMPLETE_LAST_SENTENCE.getMessage());
        return sb.toString();
    }

    private ArrayList<Integer> setCompareArray() {
        Collections.sort(cars);
        ArrayList<Integer> compareArray = new ArrayList<>();
        for (int i = 0; i < cars.size() - 1; i++) {
            compareArray.add(cars.get(i).compareTo(cars.get(i + 1)));
        }
        return compareArray;
    }

    private int getHowManyWinners(ArrayList<Integer> compareArray) {
        int count = 1;
        if (!hasDuplicatedWinners(compareArray, 0)) return count;
        for (int i = 0; i < compareArray.size(); i++) {
            if (!hasDuplicatedWinners(compareArray, i)) break;
            count++;
        }
        return count;
    }

    private boolean hasDuplicatedWinners(ArrayList<Integer> compareArray, int index) {
        return compareArray.get(index) == 0;
    }


}
