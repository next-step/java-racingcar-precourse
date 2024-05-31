package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Input {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> carNameInput() {
        try {
            List<String> carNames = List.of(br.readLine().split(","));
            return carNames.stream().map(String::trim).filter(str -> !str.isEmpty()).toList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String tryCountInput() {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
