package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

public class GameErrors {
    private String defaultMessage;

    public void clear() {
        this.defaultMessage = new String();
    }

    public boolean hasError() {
        return !StringUtils.isBlank(defaultMessage);
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
