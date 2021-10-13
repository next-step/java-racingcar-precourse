package racinggame.message;

public class MessageController extends MessageServiceImpl {
    static MessageController messageController;
    private MessageController() {
    }

    public static MessageController getInstance() {
        if(messageController == null) {
            messageController = new MessageController();
        }

        return messageController;
    }
}
