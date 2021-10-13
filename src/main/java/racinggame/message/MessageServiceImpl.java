package racinggame.message;

import racinggame.model.Car;

public class MessageServiceImpl implements MessageService {
    @Override
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void count() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void resultDescription() {
        lineFeed();
        System.out.println("실행 결과");
    }

    @Override
    public void result(Car car) {
        int position = car.getPosition();
        StringBuffer dot = new StringBuffer();

        for (int i = 0; i < position; i++) {
            dot.append("-");
        }

        System.out.printf("%s : %s%n", car.getName(), dot);

    }

    @Override
    public void winner(String winners) {
        System.out.printf("최종 우승자는 %s 입니다.%n", winners);
    }

    @Override
    public void error() {
        System.out.println("[ERROR]");
    }

    @Override
    public void lineFeed() {
        System.out.print("\n");
    }
}
