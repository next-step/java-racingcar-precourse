package racingcar.domain;

public class CarOffset {
    private Integer offset;

    public CarOffset() {
        this.offset = 0;
    }

    public void increaseOffset() {
        this.offset++;
    }

    public Integer getOffset() {
        return offset;
    }
}
