import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import Session.Session;
import Session.SessionService;

public final class Server implements Runnable{
    private ServerSocket ss;
    final private int port;
    final private SessionService sessionService;
    volatile private boolean running = true;
    final private ExecutorService executor = Executors.newCachedThreadPool();
    
    public Server(int port,SessionService sessionService) {
    	this.port = port;
        this.sessionService = sessionService;
    }
    
    public void run() {
        while (running){
    		try {
				executor.submit(sessionService.create(ss.accept()));
			} catch (IOException ex) {
				Logger.getLogger(Server.class.getName()).severe(ex.getMessage());
			}
        }
    }
    
    public void start() throws IOException {
    	Logger.getLogger(Server.class.getName()).info("Starting server at port : " + port);
    	ss = new ServerSocket(port);
    	executor.submit(this);
    }
    
    public void close() {
        try {
            running = false;
            sessionService.stopAll();
            ss.close();
            ss = null;
        } catch (IOException ex) {
        	Logger.getLogger(Server.class.getName()).severe(ex.getMessage());
        	Logger.getLogger(Server.class.getName()).info("Server failed to stop and Crashed !");
        }
    }
}
