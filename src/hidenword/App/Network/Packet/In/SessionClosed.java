/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.Out.Disconnected;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;
import hidenword.App.Network.Session.SessionService;

/**
 * Notify other sessions that current session is closed
 * @author Gaëtan
 */
final public class SessionClosed implements PacketRegistryHandler.PacketHandler {
    final private SessionService service;

    public SessionClosed(SessionService service) {
        this.service = service;
    }

    @Override
    public void handle(Session session, String packet) {
        Disconnected message = new Disconnected(session);

        service.getAllSessions().forEach(target -> target.write(message));
    }

    @Override
    public String code() {
        return PacketRegistryHandler.SESSION_STOPPED;
    }
}