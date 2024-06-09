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

    public void inputIteration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        try { // 횟수 입력 검사
            this.iteration = scanner.nextInt();
            if (this.iteration < 1) {
                throw new IllegalArgumentException();
            }
        } catch (InputMismatchException e) { // 숫자가 아닌 값을 입력 받은 경우
            System.out.println("[ERROR] : 시도할 회수는 자연수만 입력 가능합니다. 다시 입력 해주세요.");
        } catch (IllegalArgumentException e) { // 0 또는 음의 정수를 입력 받은 경우
            System.out.println("[ERROR] : 시도할 회수는 자연수만 입력 가능합니다. 다시 입력 해주세요.");
        }
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getIteration() {
        return this.iteration;
    }

}
