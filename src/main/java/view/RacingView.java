package view;

import domain.Car;
import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import utils.Checker;

public class RacingView {
    private final Scanner sc;
    private final Checker checker;
    public RacingView(){
        sc=new Scanner(System.in);
        checker=new Checker();
    }

    public void startRacing(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public String inputNames()  {
        String s=sc.nextLine();
        return s;
    }
    public int inputNumber(){
        boolean isNum=false;
        System.out.println("시도할 횟수는 몇 회인가요?");
        String s="";
        while(!isNum) {
            s = sc.nextLine();
            try{
                isNum=checker.isNumeric(s);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(s);
    }

    public StringBuilder createWinnerResult(List<Car> winners) {
        StringBuilder winnerResult = new StringBuilder();
        winnerResult.append("최종 우승자 : ");
        for (Car car : winners) {
            winnerResult.append(car.createWinner());
        }
        winnerResult.deleteCharAt(winnerResult.length() - 2);
        return winnerResult;
    }

}
