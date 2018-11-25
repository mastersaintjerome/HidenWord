/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet;

import hidenword.App.Network.Session.Session;
import hidenword.App.Network.Session.SessionHandler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * All received packets and events will be mapped to a packet handler
 * For resolve the good packet handler, the packet format must be : [code]{SPACE}[arguments]
 *
 * For example :
 * "ECHO test" Packet ECHO with "test" as argument
 * "STOP" Packet STOP without arguments
 * @author Gaëtan
 */
public final class PacketRegistryHandler implements SessionHandler{

    /**
     * SESSION_STARTED packet code
     */
    final static public String SESSION_STARTED = "\0SESSION_STARTED\0";

    /**
     * SESSION_STOPPED packet code
     */
    final static public String SESSION_STOPPED = "\0SESSION_STOPPED\0";
    
    /**
     * Handle a single packet
     */
    static public interface PacketHandler {
        /**
         * Handle the packet
         *
         * @param session The receiver session
         * @param packet The packet. The code is not removed from the packet.
         */
        public void handle(Session session, String packet);

        /**
         * The handled packet code
         * @return the packet code
         */
        public String code();
    }
    
    final private Map<String, PacketHandler> handlers = new HashMap<>();
    
    
    /**
     * Create the the registry with handlers
     * @param handlers
     */
    public PacketRegistryHandler(PacketHandler[] handlers) {
        for (PacketHandler handler : handlers) {
            register(handler);
        }
    }
    
    @Override
    public void started(Session session) {
        if (handlers.containsKey(SESSION_STARTED)) {
            handlers.get(SESSION_STARTED).handle(session, SESSION_STARTED);
        }
    }
    
    @Override
    public void stopped(Session session) {
        if (handlers.containsKey(SESSION_STOPPED)) {
            handlers.get(SESSION_STOPPED).handle(session, SESSION_STOPPED);
        }
    }

    @Override
    public void received(Session session, String packet) {
        // Extract the code from the packet
        String code = packet.split(" ", 2)[0];

        if (!handlers.containsKey(code)) {
            throw new IllegalArgumentException("Invalid packet code " + code);
        }

        handlers.get(code).handle(session, packet);
}
    
    /**
     * Register a new packet handler
     * @param handler the packet handler
     */
    public void register(PacketHandler handler) {
        handlers.put(handler.code(), handler);
    }
}
