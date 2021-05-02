package dto;

public class CarResponse {
    private final String carName;
    private final int position;

    public CarResponse(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
