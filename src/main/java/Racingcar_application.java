import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Racingcar_application {

    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), ",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        Map<String, String> raceMap = new LinkedHashMap<>();
        while(st.hasMoreElements()){
            raceMap.put(st.nextToken(), "");
        }

        for(int i=0; i<cnt; i++) {
            printRacing(raceMap);
        }

    }

    private static void printRacing(Map<String, String> raceMap) {
        for(String s : raceMap.keySet()){
            System.out.println(s + " : " + raceMap.get(s));
        }
        System.out.println("");
    }

}
