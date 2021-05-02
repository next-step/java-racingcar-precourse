package dto;

public class CarDto {
    private String name;
    private int location;

    public CarDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
