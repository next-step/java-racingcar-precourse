package Model;

import Utils.SystemMessage;

public class Car {
    private String name;
    private int cnt;

    public Car(String name) throws IllegalArgumentException {
        this.name = name;
        validateName();
        cnt = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public void incCnt(){
        this.cnt += 1;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(cnt);
    }

    public void validateName() throws IllegalArgumentException{
        if (name.length() > 5) {
            throw new IllegalArgumentException(SystemMessage.CAR_NAME_OVER_SIZE_ERROR);
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException(SystemMessage.CAR_NAME_NULL_ERROR);
        }
    }
}
