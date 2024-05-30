package parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<String> obtainCarNames(String input) {
        return new ArrayList<>(List.of(input.split(",")));
    }
}
