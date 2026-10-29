public class notificationservice{
    public notification1 notification;
    public notificationservice(notification1 notification){
        this.notification=notification;
    }

    public void notifyuser(){
        notification.sendMessage();
    }
}
