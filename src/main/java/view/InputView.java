package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private String[] carNames;
    private int iteration;

    public void inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNames = scanner.nextLine().split("\\s*,\\s*");
    }

    public boolean inputIteration() {
        Scanner scanner = new Scanner(System.in);
        try {
            int iteration = scanner.nextInt();
            if (iteration < 1) {
                throw new IllegalArgumentException("[ERROR] : 시도할 회수는 자연수만 입력 가능합니다. 다시 입력 해주세요.");
            }
            this.iteration = iteration;
            return true;
        } catch (InputMismatchException | IllegalArgumentException e) { // 올바르지 않은 값을 입력 받은 경우
            System.out.println("[ERROR] : 시도할 회수는 자연수만 입력 가능합니다. 다시 입력 해주세요.");
            return false;
        }
    }


    public String[] getCarNames() {
        return this.carNames;
    }

    public int getIteration() {
        return this.iteration;
    }

}
