import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class stuManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        frame.add(panel);

        // StudentDao.getAll();
    }

}
