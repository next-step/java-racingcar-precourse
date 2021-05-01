package view;

import domain.CarNames;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    Scanner scanner = null;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public static String carNames() {
        System.out.println(String.format("경주할자동차이름을입력하세요.(이름은쉼표(%s)기준으로구분)", CarNames.NAME_SPLITTER));
        return new Scanner(System.in).next();
    }

    public static int tryCount() {
        System.out.println("시도할회수는몇회인가요?");
        return Integer.parseInt(new Scanner(System.in).next());
    }
}
