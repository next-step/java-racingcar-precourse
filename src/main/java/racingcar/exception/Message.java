package racingcar.exception;

import racingcar.car.CarName;
import racingcar.car.CarNames;

public class Message {

    public static String ofNameLength() {
        return Type.NAME_LENGTH.message();
    }

    public static String ofNamesSyntax() {
        return Type.NAMES_SYNTAX.message();
    }

    public static String ofParseInt() {
        return Type.PARSE_INT.message();
    }

    public static String ofDuplicateName() {
        return Type.DUPLICATE_NAME.message();
    }

    enum Type {

        NAME_LENGTH {

            @Override
            protected String message() {
                return String.format(
                        MESSAGE_PREFIX + "자동차 이름은 %d자 이상, %d자 이하로 지정해주세요.",
                        CarName.MIN_LENGTH, CarName.MAX_LENGTH);
            }

        },
        NAMES_SYNTAX {

            @Override
            protected String message() {
                return String.format(
                        MESSAGE_PREFIX + "자동차 이름은 %s로 구분해주세요.",
                        CarNames.SPLIT_REGEX);
            }

        },
        DUPLICATE_NAME {

            @Override
            protected String message() {
                return MESSAGE_PREFIX + "중복된 이름이 존재합니다.";
            }

        },
        PARSE_INT {

            @Override
            protected String message() {
                return MESSAGE_PREFIX + "숫자만 입력해주세요.";
            }

        };

        private static final String MESSAGE_PREFIX = "[ERROR] ";

        abstract String message();

    }

}
