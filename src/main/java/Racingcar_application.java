import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Racingcar_application {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
        List<String> carList= new ArrayList<>();
        while(st.hasMoreElements()){
            carList.add(st.nextToken());
        }
        carList.forEach(System.out::println);
    }
}
