public class ChatUser implements User {

    private final String name;
    private final ChatMediator mediator;

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, String sender) {
        System.out.println(name + " received from " + sender + ": " + message);
    }

    @Override
    public String toString() {
        return name;
    }
}
