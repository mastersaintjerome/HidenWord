/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.Out.JoinDuelGameAccept;
import hidenword.App.Network.Packet.Out.JoinDuelGameRefuse;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Packet when a Player want to join a duel game
 * @author Gaëtan
 */
final public class JoinDuelGame implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public JoinDuelGame(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        int gameId = 0;
        if(service.join(session, gameId)){
            JoinDuelGameAccept joinDuelGameAccept = new JoinDuelGameAccept(session);
            session.write(joinDuelGameAccept);
        }else{
            JoinDuelGameRefuse joinDuelGameRefuse = new JoinDuelGameRefuse(session);
            session.write(joinDuelGameRefuse);
        }
        
    }

    @Override
    public String code() {
        return "DUELJ";
    }   
}
