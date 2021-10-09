package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

/**
 * Name : ResultView <br/>
 * Description : 게임 결과 출력 클래스
 */
public class ResultView {
    public static final String DISTANCE_MARK = "-";
    private final Cars users;

    public ResultView(Cars users) {
        this.users = users;
    }

    public void printResult() {
        for(Car user : users.getUsers()) {
            printPositionEachUser(user);
        }
        System.out.println();
    }

    private void printPositionEachUser(Car user) {
        StringBuilder distance = new StringBuilder();
        for(int i=0;i<user.getPosition();i++){
            distance.append(DISTANCE_MARK);
        }
        System.out.println(user.getName()+" : "+distance.toString());
    }

    public void printWinner(String winnerNames) {
        System.out.println("최종 우승자는 "+winnerNames+" 입니다.");
    }
}
