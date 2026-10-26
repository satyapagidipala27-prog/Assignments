public class Main{
    public static void main(String[] args){
        notification1 notification=new Emailsender();
        notificationservice service=new notificationservice(notification);
        service.notifyuser();

    }

}