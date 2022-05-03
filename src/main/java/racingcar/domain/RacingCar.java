package racingcar.domain;

public class RacingCar {
    private int position;
    private String name;

    public RacingCar(String racingCarName){
        this.position = 0;
        this.name = racingCarName;
    }

    public int getRacingCarPosition(){
        return this.position;
    }

    public void moveCarOrNot(int generatedNumber){
        if(generatedNumber >= 4){
            moveRacingCar();
        }
    }

    private void moveRacingCar(){
        this.position += 1;
    }

    public String positionToString(){
        String stringPosition = "";
        for(int idx = 0; idx < this.position; idx++){
            stringPosition += "-";
        }
        return stringPosition;
    }

    public String getName(){
        return this.name;
    }
}
