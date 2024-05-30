package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> carNameInput() throws IOException {
        String carNames = br.readLine();
        return Arrays.stream(carNames.split(",")).map(String::trim).toList();
    }

    public static String tryCountInput() throws IOException {
        return br.readLine();
    }
}
