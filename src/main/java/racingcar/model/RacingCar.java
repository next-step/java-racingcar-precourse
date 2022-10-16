package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

public class RacingCar implements Comparable<RacingCar>{
    private String GAUGE_BAR = "-";
    private String name;
    private String raceStatus = "";

    public RacingCar(String name) {
        validNull(name);
        validLength(name);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    private void validNull(String name){
        if(name == null){
            throw new IllegalArgumentException(ErrorMessage.getMessage(ErrorMessage.ERR_INPUT_THE_CAR_NAME));
        }
    }

    private void validLength(String name){
        if(name.length() == 0 || name.length() > 5){
            throw new IllegalArgumentException(ErrorMessage.getMessageValidNameOneToFive());
        }
    }

    public String getRaceStatus(){
        return raceStatus;
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isForward(int i) {
        if (i <= 3){
            return false;
        }
        return true;
    }

    public void forward(){
        raceStatus += GAUGE_BAR;
    }

    public void goRace() {
        if(isForward(generateRandomNumber())){
            forward();
        }
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "raceStatus=" + raceStatus +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(RacingCar car) {
        if (car.raceStatus.length() > raceStatus.length()) {
            return -1;
        } else if (car.raceStatus.length() < raceStatus.length()) {
            return 1;
        }
        return 0;
    }
}
