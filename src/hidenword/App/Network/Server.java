package hidenword.App.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final private ServerSocket ss;
    private boolean running = true;
    int id = 0;
    
    public Server(int port) throws IOException{
        ss = new ServerSocket(port);
    }
    
    public void run() throws IOException {
        while (running){
            Socket clientSocket = ss.accept();
            ClientServerService cliThread = new ClientServerService(clientSocket, id++);
        }
    }
    
    public Socket accept () throws IOException {
            return ss.accept();
    }
    
    public void close() {
        try {
            running = false;
            ss.close();
        } catch (IOException e) {
        }
    }
}
