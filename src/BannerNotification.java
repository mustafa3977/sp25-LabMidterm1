public class BannerNotification implements Observer {
    public void update(double newPrice) {
        System.out.println("Banner Notification: Price dropped to $" + newPrice);
    }
}
