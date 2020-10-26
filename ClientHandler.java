package MiniPorject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    DBManager dbManager;


    public ClientHandler() {
    }

    public ClientHandler(Socket socket, int id,DBManager dbManager) {
        this.socket = socket;
        this.id = id;
        this.dbManager = dbManager;
    }

    @Override
    public void run() {
        try {
             inputStream = new ObjectInputStream(socket.getInputStream());
             outputStream = new ObjectOutputStream(socket.getOutputStream());
             PackageData data = null;
            if ((data = (PackageData) inputStream.readObject())!=null){
                if (data.getOperationType().equals("ADD_STUDENT")){
                    dbManager.addStudent(data.getStudent());
                }
                else if (data.getOperationType().equals("LIST_STUDENTS")){
                    ArrayList<Student>students = dbManager.getAllStudents();
                    data.setStudents(students);
                    outputStream.writeObject(data);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
