package racingcar.judge;

import racingcar.attendgroup.AttendGroup;
import racingcar.car.Car;

public class Judge {
    private AttendGroup attendGroup;
    private Integer winnerPosition;

    public Judge(AttendGroup attendGroup) {
        this.attendGroup = attendGroup;
        this.winnerPosition = 0;
    }

    public AttendGroup getAttendGroup() {
        return this.attendGroup;
    }

    public Boolean playRace() {
        for (Car car : this.attendGroup.getAttendCarList()) {
            car.setMoveCount();
            car.moveCar();
        }
        return Boolean.TRUE;
    }

    public String getRaceResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.attendGroup.getAttendCarList()) {
            stringBuilder.append(getCarRaceResult(car)).append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public String getCarRaceResult(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName()).append(" : ");
        int carPosition = car.getCarPosition();
        for (int i = 0; i < carPosition; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public String getRaceWinner() {
        this.getWinnerPosition();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.attendGroup.getAttendCarList()) {
            stringBuilder.append(judgeWinner(car));
        }
        String winner = stringBuilder.toString();
        return winner.substring(0, winner.length() - 1);
    }

    public String judgeWinner(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        if (car.getCarPosition().equals(this.winnerPosition)) {
            stringBuilder.append(car.getName()).append(",");
        }
        return stringBuilder.toString();
    }

    public void getWinnerPosition() {
        int position = 0;
        for (Car car : this.attendGroup.getAttendCarList()) {
            position = Math.max(car.getCarPosition(), position);
        }
        this.winnerPosition = position;
    }
}
