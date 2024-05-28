public class Print {

    // 출력 지원
    public void print(String p) {
        System.out.println(p);
    }

    // 에러 출력
    public void printError(String error) {
        System.out.println("[ERROR]" + error);
    }

    // 자동차 이동거리 출력
    public void printSteps(String name, int step) {
        System.out.println(name + " : " + "-".repeat(step));
    }


}
