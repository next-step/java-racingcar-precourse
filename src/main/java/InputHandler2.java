import java.util.*;

public class InputHandler2 {


    //횟수 입력받기
    public int getTryCountFromUser() {
        Scanner scanner= new Scanner(System.in);
        while (true) {//while 문으로 오류가 발생하지 않을때까지 반복 실행=> 오류가 없으면 return 해서 반복문 종료
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = scanner.nextLine();
                int num = Integer.parseInt(input);//문자열을 숫자로 변경
                validateTryCount(num);//0 이하 오류 잡기
                return num;//사용자가 입력한 횟수 전달
            } catch (NumberFormatException e) {//숫자가 아닐때
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalStateException e) {//오류가 있을때
                System.out.println(e.getMessage());
            }
        }
    }


    //0 이하 일때 오류 발생
    private void validateTryCount(int num) {
        if (num <= 0) {
            throw new IllegalStateException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
