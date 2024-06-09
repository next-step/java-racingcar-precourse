package view;

import domain.RacingCar;
import validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InputView {
    private InputView(){
    }

    public static List<RacingCar> inputCarNames(){
        String carNameStr = readLine();
        String[] carNameArr = carNameStr.split(",");
        Arrays.stream(carNameArr).forEach(InputValidator::validateIsNameLessThan5);
        return Arrays.stream(carNameArr).map(RacingCar::from).collect(Collectors.toList());
    }

    public static int inputRoundNumber(){
        return Integer.parseInt(readLine(InputValidator::validateIsNumber));
    }

    private static String readLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static String readLine(Consumer<String> validator){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validator.accept(input);
        return input;
    }
}
