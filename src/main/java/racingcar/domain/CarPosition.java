package racingcar.domain;

public class CarPosition {

    private int position = 0;

    public void moveForward(){
        this.position++;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getPosition(){
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        return position == ((CarPosition) obj).getPosition();
    }
}
