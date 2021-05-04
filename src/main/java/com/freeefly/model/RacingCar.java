package com.freeefly.model;

public class RacingCar {
    private String name;
    private Integer proceedCount;
    private Boolean isWinner;
    public RacingCar(String name) {
        this.name = name;
        this.proceedCount = 0;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public Integer getProceedCount() {
        return proceedCount;
    }

    public Boolean isWinner() {
        return isWinner == true;
    }

    public void setWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public void winBy(Integer proceedCount) {
        if (this.proceedCount.equals(proceedCount)) {
            isWinner = true;
        }
    }
    public void proceed(Boolean isProceed) {
        if (isProceed) {
            this.proceedCount++;
        }
    }
}
