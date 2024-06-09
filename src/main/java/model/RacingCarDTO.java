package model;

public class RacingCarDTO {
    // 멤버 변수
    private String name;
    private int forward;

    // 기본 생성자
    public RacingCarDTO() {
    }

    // 생성자
    public RacingCarDTO(String name) {
        setName(name);
        setForward(0);
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    // toString
    @Override
    public String toString(){
        return name + " : " + "-".repeat(forward) + "\n";
    }

}
