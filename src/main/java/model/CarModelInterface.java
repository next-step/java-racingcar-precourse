package model;

// 차 하나하나에 대한 model
public interface CarModelInterface {

    // car가 갖는 이름을 반환하는 메서드
    String getName();

    // car의 진행도를 반환하는 메서드
    int getProgress();

    // 차에 전진 혹은 정지를 명령하는 메서드
    void moveOrNot();
}
