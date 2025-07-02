import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
        JLabel lbid=new JLabel("Id");
        JTextField txtId=new JTextField(20);
        JLabel lbname=new JLabel("Name");
        JTextField txtname=new JTextField(20);
        JLabel lbage=new JLabel("Age");
        JTextField txtage=new JTextField(4);
        JLabel lbcourse=new JLabel("Course");
        JTextField txtcourse=new JTextField(4);
        JButton btnAdd=new JButton("Add");
        JButton btnUpdate=new JButton("Update");
        JButton btnDelete=new JButton("Delete");
        JButton btnSearch=new JButton("Search");

        JTable tbl1=new JTable();
        JScrollPane scrollPane=new JScrollPane(tbl1);
        panel.add(scrollPane);


        panel.add(lbid);
        panel.add(txtId);
        panel.add(lbname);
        panel.add(txtname);
        panel.add(lbage);
        panel.add(txtage);
        panel.add(lbcourse);
        panel.add(txtcourse);
        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);

        String[] columnNames = { "ID", "Name", "Age", "Course" };
DefaultTableModel model = new DefaultTableModel(columnNames, 0);
tbl1.setModel(model);

// Load data from DAO
List<student> students = StudentDao.getAll();
for (student s : students) {
    Object[] row = { s.getId(), s.getName(), s.getAge(), s.getCourse() };
    model.addRow(row);
}


        // StudentDao.getAll();
    }

}
