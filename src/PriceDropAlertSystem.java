import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PriceDropAlertSystem {
    private double price = 1000.0;
    private final List<Observer> observers = new ArrayList<>();
    private JLabel priceLabel;

    public void start() {
        observers.add(new EmailNotification());
        observers.add(new PushNotification());
        observers.add(new BannerNotification());
        observers.add(new SmsNotification());

        JFrame frame = new JFrame("Price Drop Alert System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Dell Laptop Price Monitor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel);

        priceLabel = new JLabel("Current Price: $" + price);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(priceLabel);

        JButton dropButton = new JButton("Drop Price by $100");
        dropButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dropPrice();
            }
        });
        frame.add(dropButton);

        frame.setVisible(true);
    }

    private void dropPrice() {
        price -= 100;
        priceLabel.setText("Current Price: $" + price);
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
