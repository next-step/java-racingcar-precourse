package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    BufferedReader br;

    public InputView(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String[] inputCarNames() throws IOException {
        System.out.println("경주할 자동차의 이름들을 입력하시오. (자동차이름 사이는 쉼표(,)로 구분");
        System.out.println("ex) Alpha,Bravo,Charlie");
        String inputLine = br.readLine();
        String[] carNames = inputLine.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(String[] carNames){
        for(String name : carNames){
            if(name.length() > 5 || name.length() == 0){
                throw new IllegalArgumentException("[Error] 자동차 이름은 1~5자 사이만 가능합니다.");
            }
        }
    }

    public int inputTimes() throws IOException {
        System.out.println("자동차 경주의 횟수를 입력하시오");
        String times = br.readLine();
        validateTimes(times);
        return Integer.parseInt(times);
    }

    private void validateTimes(String times){
        char time = times.charAt(0);
        if(time == 48){
            throw new IllegalArgumentException("[Error] 최소 한번 이상의 경주횟수를 입력해 주세요");
        }

        if(!Character.isDigit(time)){
            throw new IllegalArgumentException("[Error] 숫자의 형태로 입력해 주세요");
        }
    }
}
