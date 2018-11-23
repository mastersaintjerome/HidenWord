package hidenword.App.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import hidenword.App.Network.Session.SessionService;

/**
 * Server class
 * @author Gaëtan
 */
public final class Server implements Runnable {
    private ServerSocket ss;
    final private int port;
    final private SessionService sessionService;
    volatile private boolean running = true;
    final private ExecutorService executor = Executors.newCachedThreadPool();
    final private Logger logger;
    
    /**
     * Create a new Server
     * @param port
     * @param sessionService
     */
    public Server(int port,SessionService sessionService) {
    	this.port = port;
        this.sessionService = sessionService;
        logger = Logger.getLogger(Server.class.getName());
    }
    
    @Override
    public void run() {
        while (running){
            try {
                executor.submit(sessionService.create(ss.accept()));
            } catch (IOException ex) {
                logger.severe(ex.getMessage());
            }
        }
    }
    
    /**
     * Start the server
     * @throws IOException
     */
    public void start() throws IOException {
    	logger.log(Level.INFO, "Starting server at port : {0}", port);
    	ss = new ServerSocket(port);
    	executor.submit(this);
    }
    
    /**
     * Close the server
     */
    public void stop() {
        try {
            running = false;
            sessionService.stopAll();
            ss.close();
            ss = null;
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
            logger.info("Server failed to stop and Crashed !");
        }
    }
}
