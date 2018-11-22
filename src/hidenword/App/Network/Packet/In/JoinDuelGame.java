/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.Out.JoinDuelGameAccept;
import hidenword.App.Network.Packet.Out.JoinDuelGameRefuse;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Room.DuelRoom;
import hidenword.App.Network.Room.Room;
import hidenword.App.Network.Session.Session;
import hidenword.App.Network.Session.SessionService;

/**
 * Packet when a Player want to join a duel game
 * @author Gaëtan
 */
final public class JoinDuelGame implements PacketRegistryHandler.PacketHandler {
    final private SessionService service;
    
    public JoinDuelGame(SessionService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        if(service.getRooms().get(session.getRoomId()).join(session)){
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
