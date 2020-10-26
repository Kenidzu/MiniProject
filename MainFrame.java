package MiniPorject;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainMenu mainMenupage;
    private AddStudent addStudentpage;
    private ListStudents listStudentspage;

    public ArrayList<Student> students = new ArrayList<>();

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Application");
        setSize(500,500);
        setLayout(null);

        mainMenupage = new MainMenu(this);
        mainMenupage.setVisible(true);
        add(mainMenupage);

        addStudentpage = new AddStudent(this);
        addStudentpage.setVisible(true);
        add(addStudentpage);


        listStudentspage = new ListStudents(this);
        listStudentspage.setVisible(true);
        add(listStudentspage);


    }

    public MainMenu getMainMenupage() {
        return mainMenupage;
    }

    public AddStudent getAddStudentpage() {
        return addStudentpage;
    }

    public ListStudents getListStudentspage() {
        return listStudentspage;
    }
}
