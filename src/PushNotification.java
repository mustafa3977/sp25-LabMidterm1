public class PushNotification implements Observer {
    public void update(double newPrice) {
        System.out.println("Push Notification: New price is $" + newPrice);
    }
}
