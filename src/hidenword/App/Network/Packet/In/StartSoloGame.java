/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.Out.StartSoloGameAccept;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Packet when a Player want to start a solo game
 * @author Gaëtan
 */
final public class StartSoloGame implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public StartSoloGame(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        StartSoloGameAccept startSoloGameAccept = new StartSoloGameAccept(session);
        service.create(session, false);
        service.getGame(session).start();
        session.write(startSoloGameAccept);
    }

    @Override
    public String code() {
        return "SOLO";
    }   
}
