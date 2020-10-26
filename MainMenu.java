package MiniPorject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JPanel{
    private MainFrame parent;
    private JButton AddStudent;
    private JButton ListStudents;
    private JButton exitButton;
    ArrayList <Student> studenttable = new ArrayList<>();


    public MainMenu(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        boolean connect = Main.connect();

        AddStudent = new JButton("Add Student");
        AddStudent.setSize(300,30);
        AddStudent.setLocation(100,100);
        add(AddStudent);
        AddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenupage().setVisible(false);
                parent.getAddStudentpage().showButtonsaddStudent();
                parent.getAddStudentpage().setVisible(true);
            }
        });

        ListStudents = new JButton("List Student");
        ListStudents.setSize(300,30);
        ListStudents.setLocation(100,150);
        add(ListStudents);
        ListStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenupage().setVisible(false);
                Student stud = new Student();
                PackageData data = new PackageData("LIST_STUDENTS",studenttable,stud);

                parent.getListStudentspage().generateTable(Main.student(data));
                parent.getListStudentspage().showButtonsListStudent();
                parent.getListStudentspage().setVisible(true);
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
