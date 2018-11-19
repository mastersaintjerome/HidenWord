package hidenword.App.Network.Session;

/**
 * Base Interface of Session Handler
 * @author Gaëtan
 */
public interface SessionHandler {
    
    /**
     *
     * @param session
     */
    public void started(Session session);

    /**
     *
     * @param session
     */
    public void stopped(Session session);

    /**
     *
     * @param session
     * @param packet
     */
    public void received(Session session, String packet);
}
