/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.Out.StartDuelGameAccept;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Room.DuelRoom;
import hidenword.App.Network.Room.Room;
import hidenword.App.Network.Session.Session;
import hidenword.App.Network.Session.SessionService;

/**
 * Packet when a Player want to start a duel game
 * @author Gaëtan
 */
final public class StartDuelGame implements PacketRegistryHandler.PacketHandler {
    final private SessionService service;
    
    public StartDuelGame(SessionService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        StartDuelGameAccept startDuelGameAccept = new StartDuelGameAccept(session);
        Room newDuelRoom = new DuelRoom();
        service.getRooms().add(newDuelRoom);
        session.setRoomId(service.getRooms().indexOf(newDuelRoom));
        service.getRooms().get(session.getRoomId()).create(session);
        session.write(startDuelGameAccept);
    }

    @Override
    public String code() {
        return "DUEL";
    }   
}