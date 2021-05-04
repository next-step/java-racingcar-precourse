import java.util.Scanner;

public class InputNumberCommand implements Retryable<Void, Integer> {

    @Override
    public Integer execute(Void unused) throws Exception {
        Printer.printInputGameNumber();
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        if (value < 1 || value > 20) throw new Exception("입력값은 1과 20 사이어야 합니다.");
        return value;
    }

    @Override
    public void onError(Exception e) {
        Printer.printInputError(e.getLocalizedMessage());
    }
}
