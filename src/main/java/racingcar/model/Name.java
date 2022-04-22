package racingcar.model;

import racingcar.util.StringUtil;
import racingcar.view.ResultView;

public class Name {
    public static final int MAX_SIZE = 5;

    private final String name;

    public Name(String name) {
        name = StringUtil.removeSpace(name);
        validateCheckName(name);

        this.name = name;
    }

    private void validateCheckName(String name) {
        if(StringUtil.isBlank(name)){
            throw new IllegalArgumentException(ResultView.ERROR_NAME_BLANK);
        }

        if(name.length() > MAX_SIZE){
            throw new IllegalArgumentException(ResultView.ERROR_NAME_MAX_SIZE);
        }
    }

    public String getName() {
        return this.name;
    }
}
