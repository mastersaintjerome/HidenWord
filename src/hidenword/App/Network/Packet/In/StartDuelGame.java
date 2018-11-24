/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.Out.StartDuelGameAccept;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Packet when a Player want to start a duel game
 * @author Gaëtan
 */
final public class StartDuelGame implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public StartDuelGame(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        StartDuelGameAccept startDuelGameAccept = new StartDuelGameAccept(session);
        service.create(session, false);
        session.write(startDuelGameAccept);
    }

    @Override
    public String code() {
        return "DUEL";
    }   
}