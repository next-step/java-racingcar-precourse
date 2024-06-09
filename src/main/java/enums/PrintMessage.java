package enums;

public enum PrintMessage {
    ERROR("[ERROR] ");

    private final String message;

    PrintMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
