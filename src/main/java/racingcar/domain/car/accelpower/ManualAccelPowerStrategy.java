package racingcar.domain.car.accelpower;

public class ManualAccelPowerStrategy implements AccelPowerStrategy{

    @Override
    public boolean isMove() {
        return false;
    }
}
