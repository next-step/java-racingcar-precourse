import java.util.*;
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputHandler inputHandler= new InputHandler(scanner);//사용자 입력 받는 객체 생성
        Vector<Racer> racers = inputHandler.getRacersFromUser();//자동자 이름 입력받는 메서드 호출
    }
}
