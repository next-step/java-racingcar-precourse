public class CarClient {
    public static void main(String[] args) {
        Racing racing = new Racing("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        racing.count();
        racing.start();
        racing.winners();
    }
}
