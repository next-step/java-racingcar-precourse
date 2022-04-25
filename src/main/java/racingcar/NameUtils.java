package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameUtils {
    public static List<Name> mapToList(String strNames) {
        String strWithoutSpaces = strNames.replaceAll(" ", "");
        List<String> strList = Arrays.asList(strWithoutSpaces.split(","));
        return toName(strList);
    }

    private static List<Name> toName(List<String> strList) {
        List<Name> names = new ArrayList<>();
        for (String str : strList){
            names.add(new Name(str));
        }
        return names;
    }
}
