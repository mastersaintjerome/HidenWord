/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.Out.Welcome;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 *
 * @author Gaëtan
 */
final public class SessionStarted implements PacketRegistryHandler.PacketHandler{

    @Override
    public void handle(Session session, String packet) {
        session.write(new Welcome(session));
    }

    @Override
    public String code() {
        return PacketRegistryHandler.SESSION_STARTED;
    }
    
}
