package observer;

// Observer pattern의 subject
public interface Subject {

    // 관찰 대상인 클래스에서, 관찰하는 클래스를 addObserver하면 자동으로 변화를 감지
    void addObserver(Observer observer);

    // 사용하지는 않았지만, Observer를 제거하는 메서드도 존재
    void removeObserver(Observer observer);

    // Observer의 update를 직접 호출해서 값의 변화가 일어났음을 알리는 메서드
    void notifyObservers();
}
