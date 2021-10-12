package racinggame.utils;

import java.util.Objects;

public class Message {
    public static final Message COMMA = new Message(",");
    private static final String ERROR = "[ERROR] ";
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void print() {
        System.out.println(this.content);
    }

    public void printError() {
        System.out.println(ERROR + this.content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message)o;
        return Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
