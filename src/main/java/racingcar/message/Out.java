package racingcar.message;

public class Out {

    public static void printNextLine(){
        System.out.println();
    }

    public static void printInputTheRacingCarNames(){
        System.out.println(Message.MSG_INPUT_THE_RACING_CAR_NAMES);
    }

    public static void printInputTheRacingCount() {
        System.out.println(Message.MES_INPUT_THE_RACING_COUNT);
    }
    public static void printValidRaceCount(){
        System.out.println(ErrorMessage.ERR_VALID_RACE_COUNT);
    }

    public static void printResult() {
        System.out.println(Message.MSG_RESULT);
    }

    public static void printWinner(String winners){
        System.out.println(String.format(Message.MSG_WINNER_FORMAT, winners));
    }

    public static void printValidNameOneToFile(){
        System.out.println(ErrorMessage.getMessageValidNameOneToFive());
    }

    public static void printOneRaceResult(String name, String raceStatus) {
        System.out.println(String.format("%s : %s", name, raceStatus));
    }
}
