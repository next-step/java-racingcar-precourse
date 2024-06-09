package view;

import java.util.Map;

public class OutputView {

    /**
     * 에러가 발생했을시 [ERROR]로 시작하는 에러메시지 출력하는 메서드
     *
     * @param err 에러메시지
     */
    public void printError(String err){
        System.out.println("[ERROR]" + err);
    }

    public void outputText(){
        System.out.println("실행 결과");
    }

    public void printResult(Map<String,Integer> cars){
        for(String name: cars.keySet()){
            System.out.println(name+ " : " + "-".repeat(Math.max(0, cars.get(name))));
        }
        System.out.println();
    }

    //TODO 승자 출력하기
}
