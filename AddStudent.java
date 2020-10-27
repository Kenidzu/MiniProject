package MiniPorject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudent extends JPanel {
    private MainFrame parent;
    private JButton addButton;
    private JButton backButton;
    private JLabel labelname;
    private JLabel labelsurname;
    private JLabel labelage;
    private JTextField textFieldName;
    private JTextField textFieldsurname;
    private JTextField textFieldage;

    public void showButtonsaddStudent(){
        addButton.setVisible(true);
        backButton.setVisible(true);
        labelname.setVisible(true);
        labelsurname.setVisible(true);
        labelage.setVisible(true);
        textFieldName.setVisible(true);
        textFieldsurname.setVisible(true);
        textFieldage.setVisible(true);
    }

    public AddStudent(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        labelname = new JLabel("Name:");
        labelname.setSize(300,30);
        labelname.setLocation(100,100);
        labelname.setVisible(false);
        add(labelname);

        textFieldName = new JTextField("");
        textFieldName.setSize(300,30);
        textFieldName.setLocation(180,100);
        textFieldName.setVisible(false);
        add(textFieldName);

        labelsurname = new JLabel("Surname:");
        labelsurname.setSize(300,30);
        labelsurname.setLocation(100,150);
        labelsurname.setVisible(false);
        add(labelsurname);

        textFieldsurname = new JTextField("");
        textFieldsurname.setSize(300,30);
        textFieldsurname.setLocation(180,150);
        textFieldName.setVisible(false);
        add(textFieldsurname);

        labelage = new JLabel("Age:");
        labelage.setSize(300,30);
        labelage.setLocation(100,200);
        labelage.setVisible(false);
        add(labelage);

        textFieldage = new JTextField("");
        textFieldage.setSize(300,30);
        textFieldage.setLocation(180,200);
        textFieldage.setVisible(false);
        add(textFieldage);


        addButton = new JButton("Add");
        addButton.setSize(100,30);
        addButton.setLocation(100,300);
        addButton.setVisible(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String surname = textFieldsurname.getText();
                String ages =  textFieldage.getText();
                if (!name.equals("") || !surname.equals("")){
                    if (!ages.equals("")){
                        int age = Integer.parseInt(ages);
                        Student stud = new Student(name,surname,age);
                        ArrayList<Student> students = new ArrayList<>();
                        PackageData data = new PackageData("ADD_STUDENT",students,stud);
                        Main.addServer(data);
                        textFieldName.setText("");
                        textFieldsurname.setText("");
                        textFieldage.setText("");
                    }
                    else if (ages.equals("")){
                        System.out.println("Введите возраст студента");
                    }

                }


            }
        });
        add(addButton);

        backButton = new JButton("Back");
        backButton.setSize(100,30);
        backButton.setLocation(250,300);
        backButton.setVisible(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentpage().setVisible(false);
                parent.getMainMenupage().setVisible(true);
            }
        });
        add(backButton);
    }



}
