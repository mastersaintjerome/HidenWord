package hidenword.App.Network.Session;

import hidenword.App.Network.Room.Room;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * SessionService Class, use to manage Session
 * @author Gaëtan
 */
final public class SessionService {
    private SessionHandler handler;
    final private Set<Session> sessions = new HashSet();
    final private ArrayList<Room> rooms = new ArrayList();
    
    /**
     * Create a SessionService
     * @param handler
     */
    public SessionService(SessionHandler handler) {
        this.handler = handler;
    }

    
    /**
     * Create a Session with a clientSocket
     * @param clientSocket
     * @return
     */
    public Session create(Socket clientSocket){
        Session session = new Session(clientSocket,this,handler);
        Logger.getLogger(SessionService.class.getName()).info("New session created : " + session);
        sessions.add(session);
        return session;
    }
	
    /**
     * Stop all Session
     */
    public void stopAll() {
        for(Session session : new ArrayList<>(sessions)) {
            session.stop();
        }
        sessions.clear();
    }
	
    /**
     * Return all Session
     * @return all Session
     */
    public Collection<Session> getAllSessions() {
        return sessions;
    }
	
    /**
     * Remove the Session in parameter
     * @param session
     */
    public void remove(Session session) {
        this.sessions.remove(session);
        Logger.getLogger(SessionService.class.getName()).info("Session destroyed !");
    }	

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
