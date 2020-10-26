package MiniPorject;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.connect();
        try {
            ServerSocket server = new ServerSocket(2010);
            int id = 0;
            while (true){
                Socket socket = server.accept();
                id++;
                System.out.println("Client " + id + "connected");
                ClientHandler ch = new ClientHandler(socket,id,dbManager);
                ch.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
