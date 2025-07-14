import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        FlowLayout lay = new FlowLayout();
        panel.setLayout(lay);

        frame.add(panel);
        JLabel lbid = new JLabel("Id");
        JTextField txtId = new JTextField(20);
        JLabel lbname = new JLabel("Name");
        JTextField txtname = new JTextField(20);
        JLabel lbage = new JLabel("Age");
        JTextField txtage = new JTextField(4);
        JLabel lbcourse = new JLabel("Course");
        JTextField txtcourse = new JTextField(4);
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnSearch = new JButton("Search");

        JTable tbl1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(tbl1);
        panel.add(scrollPane);
        String[] columnNames = { "ID", "Name", "Age", "Course" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

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

        tbl1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tbl1.getSelectedRow();
                txtId.setText(tbl1.getValueAt(selectedRow, 0).toString());
                txtname.setText(tbl1.getValueAt(selectedRow, 1).toString());
                txtage.setText(tbl1.getValueAt(selectedRow, 2).toString());
                txtcourse.setText(tbl1.getValueAt(selectedRow, 3).toString());
            };

        });

        tbl1.setModel(model);

        List<student> students = StudentDao.getAll();
        for (student s : students) {
            Object[] row = { s.getId(), s.getName(), s.getAge(), s.getCourse() };
            model.addRow(row);
        }

        btnAdd.addActionListener(ActionListener -> {
            StudentDao.add(txtId, txtname, txtage, txtcourse);
            Object[] row = { txtId.getText(), txtname.getText(), txtage.getText(), txtcourse.getText() };
            model.addRow(row);
        });
        btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbl1.getSelectedRow();

                if (selectedRow >= 0) {
                    model.setValueAt(txtId.getText(), selectedRow, 0);
                    model.setValueAt(txtname.getText(), selectedRow, 1);
                    model.setValueAt(txtage.getText(), selectedRow, 2);
                    model.setValueAt(txtcourse.getText(), selectedRow, 3);

                    JOptionPane.showMessageDialog(null, "Row updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to update.");
                }
            }
        });

    }

}
