import util.Car;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Car carObject;
    Scanner scanner;
    int gameCount;
    Random random;

    Game(){
        carObject = new Car();
        random = new Random();
    }

    public void carNameInput(){
      scanner = new Scanner(System.in);
      System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
      String fullString = scanner.nextLine();
      String[] arrayString = fullString.split(",");
      carObject.initCarList(arrayString.length);
      carObject.initCarProcessList(arrayString.length);
      for(int i=0;i<arrayString.length;i++) carObject.setCarList(arrayString[i], i);
    }

    public void randomInitCountInput(){
      scanner = new Scanner(System.in);
      System.out.println("시도할 횟수는 몇회인가요?");
      try { int caseCount = Integer.parseInt(scanner.nextLine());
            if(caseCount > 0) {
                gameCount = caseCount;
            }else{ throw new AssertionError("음수는 계산 불가능합니다."); }
      }catch (NumberFormatException e){
          System.out.print("숫자 미입력 OR 초과수 에러 : ");
          e.printStackTrace(); }
    }

    public void randomCountResult(int index){
        int count = random.nextInt(10);
        if(count < 4) {
            carObject.minosCarProcessValue(index);
            return;
        }
        carObject.plusCarProcessValue(index);
    }

    public String viewStringResult(int index){
       return carObject.getCarList(index) + ":" + carObject.getCarProcessStringList(index);
    }

    public int returnMaxCount(){
        int[] maxTempArray = new int[carObject.getCarListLength()];
        for(int i=0;i<carObject.getCarListLength();i++) maxTempArray[i] = carObject.getCarProcessValueList(i);
        Arrays.sort(maxTempArray);
        return maxTempArray[maxTempArray.length-1];
    }

    public boolean returnIndexCount(int maxCount, int index){
        if(maxCount == carObject.getCarProcessValueList(index)) return true;
        return false;
    }

    public String returnCalulatorString(boolean calculatorBoolean, int index){
         if(calculatorBoolean == true) return carObject.getCarList(index) + ",";
         return "";
    }

}
