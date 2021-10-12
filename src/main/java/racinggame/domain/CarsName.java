package racinggame.domain;


public class CarsName {
    public String carsName;
    public Boolean isValidValue;
    public static Validation validation;

    public CarsName(String carsName) {
        this.isValidValue = true;
        this.validation = new Validation();
        isValidName(carsName);
        this.carsName = trimCarsName(carsName);
    }

    private String trimCarsName(String carsName) {
        return carsName.replaceAll(" ", "");
    }

    public void isValidName(String carsName) {
        carsName.replaceAll(" ", "");
        checkValid(validation.checkCarsNameNull(carsName), Message.INPUT_CARS_NULL_ERROR_MSG);
        String[] cars = carsName.split(",");
        checkValid(validation.checkCarsListNull(cars), Message.INPUT_CARS_NULL_ERROR_MSG);
        for (int i = 0; i < cars.length; i++) {
            checkValid(validation.checkCarNmaeLen(cars[i]), Message.INPUT_CARS_LEN_ERROR_MSG);
        }

    }

    public void checkValid(Boolean valid, String message) {
        if (!valid) {
            this.isValidValue = false;
            makeException(message);
        }
    }

    public static void makeException(String message) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(message);
        }
    }
}
