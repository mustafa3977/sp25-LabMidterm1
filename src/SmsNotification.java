public class SmsNotification implements Observer {
    public void update(double newPrice) {
        System.out.println("SMS Notification: New price is $" + newPrice);
    }
}
