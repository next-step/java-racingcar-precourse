package view;

import domain.CarNames;
import domain.TryCount;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = null;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public CarNames carNames() {
        System.out.println(String.format("경주할자동차이름을입력하세요.(이름은쉼표(%s)기준으로구분)", CarNames.NAME_SPLITTER));

        return new CarNames(scanner.next());
    }

    public TryCount tryCount() {
        System.out.println("시도할회수는몇회인가요?");

        return new TryCount(scanner.next());
    }
}
