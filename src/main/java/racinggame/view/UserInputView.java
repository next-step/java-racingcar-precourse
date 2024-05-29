package racinggame.view;

import java.util.Scanner;
import racinggame.validator.RacingGameInputValidator;

public class UserInputView {
    private Scanner scanner = new Scanner(System.in);
    private RacingGameInputValidator racingGameInputValidator;

    // 만들어뒀던 racingGameInputCalidator를 사용하여 입력 값을 검증
    public UserInputView(RacingGameInputValidator racingGameInputValidator) {
        this.racingGameInputValidator = racingGameInputValidator;
    }

    public String getCarNames(){
        // 오류가 난 지점에서 다시 시작할 수 있도록 while 문 사용
        while (true){
            try{
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String carNames = scanner.nextLine();
                racingGameInputValidator.isValidateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
