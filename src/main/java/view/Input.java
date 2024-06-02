package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static view.Prompt.ENTER_CAR_NAMES;

public class Input {

    public static final Scanner scanner = new Scanner(System.in);

    private Input() {

    }

    /**
     *
     * @return 사용자가 입력한 자동차 이름 리스트 (쉼표로 구분)
     */
    public static ArrayList<String> getCarNames() {
        System.out.println(ENTER_CAR_NAMES);
        String userInput = scanner.nextLine();
        String[] nameArray = userInput.split(",", -1);
        return new ArrayList<>(Arrays.asList(nameArray));
    }



}
