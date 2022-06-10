package racingcar.domain.name;

import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private List<Name> names = new ArrayList<>();

    public Names(String nameInput) {
        defineNames(nameInput);
    }

    private void defineNames(String nameInput) {
        String[] splitText = StringUtil.splitText(nameInput);

        for (String text: splitText) {
            names.add(new Name(text));
        }
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }
}
