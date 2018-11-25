/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.Out.CreateDuelGameAccept;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Packet when a Player want to create a duel game
 * @author Gaëtan
 */
final public class CreateDuelGame implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public CreateDuelGame(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        CreateDuelGameAccept startDuelGameAccept = new CreateDuelGameAccept(session);
        service.create(session, true);
        session.write(startDuelGameAccept);
    }

    @Override
    public String code() {
        return "DUEL";
    }   
}