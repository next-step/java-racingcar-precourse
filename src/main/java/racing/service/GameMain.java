package racing.service;

import racing.vo.Racing;
import racing.vo.Reception;
import racing.vo.Rule;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {

    private Scanner sc;
    private Reception reception;
    private Rule rule;

    public GameMain(){
        ready();
    }

    private void ready() {
        try{
            this.reception = inputName();
            this.rule = inputRound();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void start(){
        Racing racing = new Racing(this.rule,this.reception);
        RacingGame racingGame = new RacingGame(racing);
        System.out.println("\r\n실행결과");
        racingGame.startRound();
    }

    private Reception inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Reception reception = new Reception(new ArrayList());
        sc = new Scanner(System.in);
        reception.register(sc.next());
        return reception;
    }

    private Rule inputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        sc = new Scanner(System.in);
        String inputRound = sc.next();
        return new Rule(inputRound);
    }

}
