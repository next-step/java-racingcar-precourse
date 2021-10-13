package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Names {

    private static final String DELIMITER = ",";
    private static final String ERROR_INVALID_NAMES = "[ERROR] 이름은 쉼표(,) 기준으로 구분할 수 있습니다.";

    private final List<Name> names;

    public Names(final String commaSeparatedNames) {
        this.names = new ArrayList<>();
        addNames(commaSeparatedNames);
    }

    private void addNames(final String commaSeparatedNames) {
        for (String name : splitNames(commaSeparatedNames)) {
            this.names.add(new Name(name));
        }
    }

    private String[] splitNames(final String commaSeparatedNames) {
        try {
            return commaSeparatedNames.split(DELIMITER);
        } catch (PatternSyntaxException ex) {
            throw new IllegalArgumentException(ERROR_INVALID_NAMES);
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(this.names);
    }
}
