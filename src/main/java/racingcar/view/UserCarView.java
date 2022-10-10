package racingcar.view;

public class UserCarView extends RacingCarView{

    @Override
    public void print() {
        super.print();
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }
}
