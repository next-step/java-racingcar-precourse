package controller;

// 실제 사용자가 조작할 컨트롤러
public interface RaceControllerInterface {

    // 사용자가 조작하는 프로그램의 첫 부분
    public void init();

    // 사용자가 조작하는 프로그램의 중간 부분
    public void play();

    // 사용자가 조작하는 프로그램의 마지막 부분
    public void end();

    // view로부터 입력을 받아서 service로 차들의 이름을 전송하는 메서드
    public void addCars(String[] cars);

    // view로부터 입력을 받아서 service로 round의 횟수를 전송하는 메서드
    public void setRound(String numberOfRound);
}
