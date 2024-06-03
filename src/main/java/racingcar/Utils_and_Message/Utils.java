package racingcar.Utils_and_Message;

public class Utils {
    public static int getMax(int[] array){
        int max = array[0]; // 배열의 첫 번째 요소를 초기 최대값으로 설정
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // 현재 요소가 최대값보다 크면 최대값을 갱신
            }
        }
        return max;
    }

}
