package racinggame.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Name : Cars <br/>
 * Description : 레이싱 게임 참가자 클래스
 */
public class Cars {
    public static final int ONE = 1;
    private final List<Car> users;

    public <T> Cars(List<Car> users) {
        if (this.hasDupUser(users)) {
            throw new IllegalArgumentException("레이싱 게임 참가 자동차의 이름은 중복될 수 없습니다.");
        }
        this.users = users;
    }

    public Cars() {
        throw new IllegalArgumentException("레이싱 게임 참가 자동차는 1대이상 이어야 합니다.");
    }

    public int getUserCount() {
        return this.users.size();
    }

    public boolean hasDupUser(List<Car> users) {
        for (Car user : users) {
            return checkDupUser(users, user);
        }
        return false;
    }

    private boolean checkDupUser(List<Car> users, Car user) {
        /* Collections.frequency는 내부적으로 equals 메소드로 비교(Car 재정의) */
        return Collections.frequency(users, user) > ONE;
    }

    public List<Car> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getMaxPosition() {
        return Collections.max(getUsers(), Comparator.comparingInt(Car::getPosition)).getPosition();
    }
}
