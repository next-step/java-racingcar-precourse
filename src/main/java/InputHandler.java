import java.util.*;

public class InputHandler {


    public Vector<Racer> getRacersFromUser() {
        Scanner scanner= new Scanner(System.in);
        while (true) {//while 문으로 오류가 발생하지 않을때까지 반복 실행 => 오류가 없으면 return 해서 반복문 종료
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String names = scanner.nextLine();
                String[] splitNames = names.split(",");//,으로 나눠서 배열에 저장
                validateNames(splitNames);////5글자 초과 또는 공백 오류 잡기
                return createRacers(splitNames);//Racer 모아놓은 벡터 만드는 함수 호출

            } catch (IllegalArgumentException e) {//오류 발생시
                System.out.println(e.getMessage());
            }
        }
    }

    //5글자 초과 또는 공백 포함 시 오류 발생
    void validateNames(String[] splitNames) {
        for (String name : splitNames) {
            if (name.length() > 5 || name.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이내, 공백 불가.");
            }
        }
    }

    //Racer 모아놓은 벡터 만들기
    Vector<Racer> createRacers(String[] splitNames) {
        Vector<Racer> racers = new Vector<>(splitNames.length);

        for (String name : splitNames) {
            racers.add(new Racer(name));
        }
        return racers;
    }

}
