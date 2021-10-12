package racinggame.utils;

public class MessageBuilder {
    private static final String NEW_LINE = "\n";
    private StringBuilder builder;

    public MessageBuilder() {
        this.builder = new StringBuilder();
    }

    public MessageBuilder(Message message) {
        this.builder = new StringBuilder(message.getContent());
    }

    public MessageBuilder append(Message message) {
        builder.append(message.getContent());
        return this;
    }

    public MessageBuilder appendNewLine() {
        builder.append(NEW_LINE);
        return this;
    }

    public Message toMessage() {
        return new Message(builder.toString());
    }
}
