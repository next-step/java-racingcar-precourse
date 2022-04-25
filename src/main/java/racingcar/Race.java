package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private Cars cars;
    private RaceRecord record;
    private RaceTurn turn;
    private PositionOfHead positionOfHead;

    public static Race create(UserInput userInput) throws IllegalArgumentException {
        Race race = new Race();
        race.cars = Cars.create(userInput.getCarNames());
        race.positionOfHead = new PositionOfHead();
        race.record = new RaceRecord();
        race.turn = userInput.getTurn();
        return race;
    }

    public RaceRecord getRecord() {
        return this.record;
    }

    public Cars getCars() {
        return cars;
    }

    public void playAllTurn() {
        while(!turn.isFinished()) {
            nextRaceTurn();
        }
        record.addWinners(isWhoWinner());
    }

    public void nextRaceTurn() {
        for(Car car : cars.getCollection().values()) {
            car.canMoveForward(pickRandomNum());
            positionOfHead.setPositionIfNewHead(car);
        }
        turn.decrease();
        record.of(cars.getCollection());
    }

    public Winners isWhoWinner() {
        Winners winners = new Winners();
        for(Car car : cars.getCollection().values()) {
            addToWinnersIfHead(car, winners);
        }
        return winners;
    }

    private void addToWinnersIfHead(Car car, Winners winners) {
        if(positionOfHead.isHead(car)) {
            winners.add(car.getName());
        }
    }

    private int pickRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
