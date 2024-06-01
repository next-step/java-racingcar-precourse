package controller;

public class GameController {
    public static String[] getCarNames(String input) {
        String[] result = input.replaceAll("\\s+", "").split(",");
        System.out.println(result);
        return result;
    }
}
