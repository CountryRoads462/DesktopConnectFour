package four;

import javax.swing.*;
import java.awt.*;

public class ApplicationRunner extends JFrame {
    private ApplicationRunner() {
        super("ApplicationRunner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                String nameOfButton = "Button";
                String textOnButton;


                JButton cell = new JButton();
            }
        }

        setLayout(new GridLayout(6, 7));
        setVisible(true);
    }

    public static void main(String[] args) {
        new ApplicationRunner();
    }
}