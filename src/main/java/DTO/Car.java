package DTO;

public class Car {

    private String carNm;
    private int  carMvInfo;

    public Car() {
        this.carMvInfo = 0;
    }
    public Car(String carNm) {
        this.carNm = carNm;
        this.carMvInfo = 0;
    }

    public String getCarNm() {
        return carNm;
    }
    public void setCarNm(String carNm) {
        this.carNm = carNm;
    }
    public int getCarMvInfo() {
        return carMvInfo;
    }
    public void setCarMvInfo(int carMvInfo) {
        this.carMvInfo = carMvInfo;
    }
}
