package Model;
import java.util.ArrayList;
import java.util.Random;

public class Info {
    private final ArrayList<Car> carList = new ArrayList<>();
    private int count;

    public ArrayList<Car> getCarList(){
        return this.carList;
    }

    //입력으로 주어진 자동차 이름 문자열을 ","로 구분하여 carList 에 삽입
    public void insert(String input,int inputCount){
        this.count = inputCount;
        for(String s : input.split(",")){
            carList.add(new Car(s));
        }
    }

    //모든 자동차에 대해 0 ~ 9 사이의 난수 생성 후 해당 값이 4 이상일시 move() 호출
    public void round(){
        Random random = new Random();
        for (Car car : carList) {
            if(random.nextInt(9) >= 4)
                car.move();
        }
        //이동 횟수 감소
        this.count--;
    }

    //모든 자동차들의 전진 현황 List 을 반환
    public ArrayList<String> getProgressList(){
        ArrayList<String> result = new ArrayList<>();
        for(Car car : carList){
            result.add(car.getName() + " : " + "-".repeat(car.getProgress())); // progress 를 '-'의 길이로 표현
        }
        return result;
    }

    //최종 승자를 반환 (승자들의 이름을 ,로 구분한 문자열)
    public String getWinner(){
        int max = carList.stream().mapToInt(Car::getProgress).max().orElse(0); //최대 전진 거리 추출
        String[] result = carList.stream()
            .filter(c -> c.getProgress() == max) // 최대 전진 거리를 가지는 Car 추출
            .map(Car::getName) // name 만 추출
            .toArray(String[]::new); // 문자열 배열로 변환
        return String.join(", ",result); // 하나의 문자열로 합쳐서 반환
    }

    //남은 이동 횟수가 0이라면 레이스는 종료
    public boolean isFinish(){
        return count == 0;
    }
}
