public class Printer {
    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputError(String localizedMessage) {
        System.out.println(localizedMessage + ". 다시 입력하세요.");
    }
}
