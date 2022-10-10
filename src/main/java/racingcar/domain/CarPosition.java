package racingcar.domain;

public class CarPosition {

    private int position = 0;

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position){this.position = position;};

    public void updatePosition(int randomNum){
        if(randomNum >= 4){
            this.position ++;
        }
    }

    public String getPositionProgress(){
        String progress = "";
        for(int index=0;index<this.position;index++){
            progress += "-";
        }
        return progress;
    }

}
