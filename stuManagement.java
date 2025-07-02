import java.awt.FlowLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stuManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        FlowLayout lay= new FlowLayout();
        panel.setLayout(lay);

        frame.add(panel);

        JLabel lbname=new JLabel("Name");
        JTextField txtname=new JTextField(20);

        panel.add(lbname);
        panel.add(txtname);

        // StudentDao.getAll();
    }

}
