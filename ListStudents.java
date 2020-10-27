package MiniPorject;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
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
    private JTextArea area;
    ArrayList<Student> stud = null;


    public void showButtonsListStudent(){
        backbutton.setVisible(true);
        area.setVisible(true);

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
        area = new JTextArea();
        area.setSize(300,150);
        area.setLocation(100,150);
        area.setVisible(false);
        area.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                stud = student();
                area.append(stud.toString());
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        add(area);



    }

    public static ArrayList<Student>student(){
         ArrayList<Student>students = new ArrayList<>();
        Student stud = new Student();
        PackageData data = new PackageData("LIST_STUDENTS",students,stud);
        students = Main.student(data);
        return students;
    }
}
