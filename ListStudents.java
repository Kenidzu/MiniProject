package MiniPorject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudents extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton backbutton;
    private JTable table;
    private JScrollPane scrollPane;
    private String information [] = {"Name","Surname","Age"};


    public void showButtonsListStudent(){
        backbutton.setVisible(true);
    }

    public ListStudents() {
    }

    public ListStudents(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        backbutton = new JButton("Back");
        backbutton.setSize(100,30);
        backbutton.setLocation(175,300);
        backbutton.setVisible(false);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getListStudentspage().setVisible(false);
                parent.getMainMenupage().setVisible(true);
            }
        });
        add(backbutton);


        table = new JTable();
        table.setFont(new Font("Calibri",Font.PLAIN,12));
        table.setRowHeight(30);


        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);
    }

    public void generateTable(ArrayList<Student>students){
        Object data[][] = new Object[students.size()][information.length];

        for (int i = 0;i < students.size();i++){
            Student current = students.get(i);
            data[i][0] = current.getName();
            data[i][1] = current.getSurname();
            data[i][2] = current.getAge();
        }
        DefaultTableModel model = new DefaultTableModel(data,information);
        table.setModel(model);
    }

}
