package view;

import java.util.ArrayList;
import repository.CarRepository;

public class RacingView {
    public void showInputCarNamesMsg(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void showInputNumOfTry(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void errorMsgInputNumOfTry(){
        System.out.println("[ERROR]유효한 숫자를 입력해주세요.");
    }
    public void showRacingStartMsg(){
        System.out.println("실행 결과");
    }
    public void showRacing(CarRepository carRepository){
        System.out.println(carRepository.toString());
    }
    public void showWinnerList(ArrayList<String> winnerArrList){
        StringBuilder sb = new StringBuilder();
        sb.append("최종우승자 : ");
        for(int i=0; i<winnerArrList.size()-1; i++){
            sb.append(winnerArrList.get(i)).append(", ");
        }
        sb.append(winnerArrList.get(winnerArrList.size()-1));
        System.out.println(sb);
    }
}
