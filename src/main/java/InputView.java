import java.util.List;
import java.util.Scanner;

public class InputView {
    public String inputCars() {
        System.out.println(Messages.INPUT_CAR_NAMES);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public int inputMoveNumber() {
        System.out.println(Messages.INPUT_REPEAT_NUMBER);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
