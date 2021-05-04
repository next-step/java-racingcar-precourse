package racingcar.exception;

import static racingcar.exception.message.ErrorMessage.UN_RECORDABLE_TYPE_EXCEPTION;

public class RaceRecordException extends RuntimeException {
    public static class UnRecordableTypeException extends RuntimeException {
        public UnRecordableTypeException() {
            super(UN_RECORDABLE_TYPE_EXCEPTION.getMessage());
        }
    }
}
