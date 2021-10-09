package racinggame.domain;

public class Car {

    private String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Car of(String name) {
        return new Car(name);
    }


    public static void validateName(String name) {
       validateNullOrEmptyName(name);
       validateExceededName(name);
    }

    public static void validateNullOrEmptyName(String name) {
        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException(ErrorCode.NAME_NOT_BLANK.getMessage());
        }
    }

    public static void validateExceededName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorCode.NAME_EXCEEDED.getMessage());
        }
    }
}
