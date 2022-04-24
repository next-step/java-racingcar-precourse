package racingcar.vo;

public class Player {
    private String name;
    private long position;

    public Player(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public long getPosition() {
        return position;
    }
    public void setPosition(long position) {
        this.position = position;
    }
}
