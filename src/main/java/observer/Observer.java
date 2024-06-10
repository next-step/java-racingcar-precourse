package observer;

// Observer pattern을 위한 observer
public interface Observer {

    // 내부의 변수를 참조해서 update하면, 바로 view에 변화를 출력한다.
    void update();
}
