package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import racingcar.constant.GameEnvironment;
import racingcar.exception.DuplicatedCarNameException;
import racingcar.view.UserInput;

public class Names {
    private final List<Name> value;

    public Names(UserInput userInput) {
        this.value = generate(splitByDelimiter(userInput));
        verifyDuplicatedCarName();
    }

    public Names(List<Name> value) {
        this.value = value;
    }

    private void verifyDuplicatedCarName() {
        Set<Name> names = new LinkedHashSet<>(value);
        if (names.size() != value.size()) {
            throw new DuplicatedCarNameException();
        }
    }

    public int size() {
        return value.size();
    }

    public Name get(int index) {
        return this.value.get(index);
    }

    public List<Name> getValue() {
        return Collections.unmodifiableList(value);
    }

    private String[] splitByDelimiter(UserInput userInput) {
        return userInput.getValue().split(GameEnvironment.CAR_NAME_DELIMITER);
    }

    private List<Name> generate(String[] names) {
        List<Name> nameList = new LinkedList<>();
        for (String name : names) {
            nameList.add(new Name(name));
        }

        return nameList;
    }

}
