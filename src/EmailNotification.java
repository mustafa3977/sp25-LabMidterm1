public class EmailNotification implements Observer {
    public void update(double newPrice) {
        System.out.println("Email Notification: New price is $" + newPrice);
    }
}
