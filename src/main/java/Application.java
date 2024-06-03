import java.io.*;
import java.util.Vector;

public class Application {

    public static void main(String[] args) throws IOException {
        Vector<Car> cars = new Vector<Car>();
        boolean carnamevalid = false;
        boolean attemptcountvalid = false;
        int attemptnumber = 0;

        //사용자 입력 받기
        do {
            try {
                InputHandler.CarNameInput(cars);
                carnamevalid = InputValidator.validateCarName(cars); //유효성 검사
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!carnamevalid);

        do {
            try {
                attemptnumber = InputHandler.attemptCountInput();
                attemptcountvalid = InputValidator.validateAttemptCount(attemptnumber); //유효성 검사
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!attemptcountvalid);

        //전진하기
        for (int i = 0; i < attemptnumber; i++) {
            AdvanceFoward.advanceFoward(cars);
            OutputHandler.fowardOutput(cars);
        }

        //우승자 출력
        OutputHandler.winnerOutput(cars);
    }

}