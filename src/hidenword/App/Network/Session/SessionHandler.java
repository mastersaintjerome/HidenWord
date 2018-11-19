package hidenword.App.Network.Session;

/**
 * Base Interface of Session Handler
 * @author Gaëtan
 */
public interface SessionHandler {
    
    /**
     * Session started
     * @param session
     */
    public void started(Session session);

    /**
     * Session Stopped
     * @param session
     */
    public void stopped(Session session);

    /**
     * Session received packet
     * @param session
     * @param packet
     */
    public void received(Session session, String packet);
}
