/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Send to the client the received packet (Echo)
 * @author Gaëtan
 */
final public class Echo implements PacketRegistryHandler.PacketHandler {

    @Override
    public void handle(Session session, String packet) {
        session.write(packet);
    }
    
    @Override
    public String code() {
        return "ECHO";
    }
}