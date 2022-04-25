package racingcar.domain;

public class Car {
    private String name;
    private String progress;
    private boolean winner;

    public Car(String name) {
        this.name = name;
        this.progress = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgress() {
        return progress;
    }

    public void plusProgress() { this.progress += "-"; }

    public void updateWinner(int maxNum) {
        if(maxNum <= this.progress.length()) setWinner(true);
        if(maxNum > this.progress.length()) setWinner(false);
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean getWinner() {
        return this.winner;
    }

    public CarStatus run(int num) {
        if(inputNumCheck(num)) return CarStatus.GO;
        return CarStatus.STOP;
    }

    public boolean inputNumCheck(int num) {
        if(num >= 4) {
            plusProgress();
            return true;
        }
        return false;
    }
}
