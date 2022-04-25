package racingcar.model;

public class Turn {

    private Integer value;

    /**
     * 턴 값 반환 함수
     *
     * @return 조회된 턴 값
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 턴 값 셋팅 함수
     *
     * @param value 셋팅할 턴 값
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}
