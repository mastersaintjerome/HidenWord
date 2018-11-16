package hidenword.App.Network.Session;

public interface SessionHandler {
    public void start(Session session);

    public void stop(Session session);

    public void receive(Session session, String packet);
}
