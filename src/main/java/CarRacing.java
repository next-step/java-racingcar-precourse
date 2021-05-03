import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public List<Cars> getCars(String cars, String sep) {
        String[] carArr = cars.split(sep);
        List<Cars> carList = new ArrayList<>();
        for (int i = 0; i < carArr.length; i++) {
            carList.add(new Cars(carArr[i].trim()));
        }
        return carList;
    }

    public List<Cars> racing(List<Cars> carList, int num) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            for (Cars car : carList) {
                int randNum = random.nextInt(10);
                if (randNum >= 4) {
                    car.setPosition(car.getPosition() + "-");
                }
            }

            System.out.println(i+1 + "번째 경주");
            carList.forEach(c -> {
                System.out.println(c.getName() + " : " + c.getPosition());
            });
            System.out.println();
        }
        return carList;
    }

    public String finish(List<Cars> finishRacing) {
        int max = 0;
        for (Cars car : finishRacing) {
            if (max < car.getLength()) {
                max = car.getLength();
            }
        }

        List<String> list = new ArrayList<>();
        for (Cars car : finishRacing) {
            if (max == car.getLength()) {
                list.add(car.getName());
            }
        }

        String result = String.join(",", list) + "가 최종 우승했습니다.";

        return result;
    }
}
