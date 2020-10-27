package MiniPorject;

import com.sun.source.tree.ReturnTree;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static Socket socket;
    public static boolean var = false;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;



    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

    }

    public static boolean connect (){
        try {
            socket = new Socket("Localhost",2010);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            var = true;
        }catch (Exception e){
            e.printStackTrace();
            var = false;
        }
        return var;
    }

    public static void addServer(PackageData packageData){
        try {
            outputStream.writeObject(packageData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> student (PackageData packageData){
        ArrayList<Student> students = new ArrayList<>();
        try {
            outputStream.writeObject(packageData);
            PackageData data = null;
            if ((data = (PackageData) inputStream.readObject())!=null){
                students = data.getStudents();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

}
