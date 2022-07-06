package racingcar.vo;

import racingcar.constant.Message;

public class Count extends Base {
    private int count;

    public Count(String input) {
        super(input);
    }

    public int getCount() {
        return count;
    }

    @Override
    protected void validate() {
        int num;

        try {
            num = Integer.parseInt(this.input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(Message.ERROR_INVLAID_COUNT);
        }

        if(num < 1) {
            throw new IllegalArgumentException(Message.ERROR_INVLAID_COUNT);
        }

        this.count = num;
    }
}
