package hidenword.App.Network.Session;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

final public class SessionService {
    private SessionHandler handler;
    final private Set<Session> sessions = new HashSet();

    public SessionService(SessionHandler handler) {
        this.handler = handler;
    }

    public Session create(Socket clientSocket){
        Session session = new Session(clientSocket,this,handler);
        Logger.getLogger(SessionService.class.getName()).info("New session created : " + session);
        sessions.add(session);
        return session;
    }
	
    public void stopAll() {
        for(Session session : new ArrayList<>(sessions)) {
                session.stop();
        }
        sessions.clear();
    }
	
    public Collection<Session> getAllSession() {
        return sessions;
    }
	
    public void remove(Session session) {
        this.sessions.remove(session);
        Logger.getLogger(SessionService.class.getName()).info("Session destroyed !");
    }	
}
