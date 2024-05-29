package katecam;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RacingCarView {
    private final Scanner scanner;
    public RacingCarView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNames(){
        display("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .toList();
    }

    public int getNumberToAttempt(){
        display("시도할 회수는 몇회인가요?");
        int numberToAttempt;
        try{
            numberToAttempt = scanner.nextInt();
        }catch (InputMismatchException e){
            throw new IllegalArgumentException("숫자를 입력하세요");
        }finally {
            scanner.nextLine();
        }
        return numberToAttempt;
    }

    public void display(String string){
        System.out.println(string);
    }
}
