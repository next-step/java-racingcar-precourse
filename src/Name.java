package src;

public class Name {
    final static String DEFAULT_NAME = "";
    private String value;

    public Name(){
        value = DEFAULT_NAME;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
