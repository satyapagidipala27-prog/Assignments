public class Main {

    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new ChatUser("Kaushik", chatRoom);
        User user2 = new ChatUser("Rahul", chatRoom);
        User user3 = new ChatUser("Priya", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hello everyone!");

        System.out.println();

        user2.send("Hi Kaushik!");
    }
}
