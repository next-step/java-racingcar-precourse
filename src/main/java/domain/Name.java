package domain;

import util.Exception;
import util.Message;

public class Name {

    private String name;

    public Name(String name) {
        this.name = getCarNameLength(name);
    }

    public String getName() {
        return name;
    }

    public String getCarNameLength(String carName) {
        if(carName.length() > 5 ) Exception.illegalArgumentException(Message.INPUT_MSG_CAR_NAME_LIMIT);
        if(carName.length() ==0 ) Exception.nullPointerException(Message.INPUT_MSG_CAR_NAME_NOT_NULL);
        return carName;
    }

}
