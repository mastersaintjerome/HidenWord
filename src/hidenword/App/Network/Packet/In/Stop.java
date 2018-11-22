/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Stop the current session
 * @author Gaëtan
 */
final public class Stop implements PacketRegistryHandler.PacketHandler {
    @Override
    public void handle(Session session, String packet) {
        session.stop();
    }

    @Override
    public String code() {
        return "STOP";
    }
}
