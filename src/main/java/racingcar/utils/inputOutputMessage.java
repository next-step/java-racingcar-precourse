package racingcar.utils;

public class inputOutputMessage {
    public void inputNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void inputCountMessage(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }
    public void executionMessage(){
        System.out.println("실행 결과");
    }
    public String outputMessage(){
        return "최종 우승자 : ";
    }
}
