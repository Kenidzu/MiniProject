package MiniPorject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/miniproject?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();
        try{

            PreparedStatement st = connection.prepareStatement("SELECT * FROM students");


            ResultSet rs = ((PreparedStatement) st).executeQuery();


            while (rs.next()){

                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");


                students.add(new Student(name,surname,age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }
    public void addStudent(Student student){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO students(name, surname, age) values(?,?,?)");
            st.setString(1,student.getName());
            st.setString(2,student.getSurname());
            st.setInt(3,student.getAge());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
