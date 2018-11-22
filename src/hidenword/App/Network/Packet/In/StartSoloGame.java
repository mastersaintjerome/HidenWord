/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Network.Packet.Out.StartSoloGameAccept;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Room.Room;
import hidenword.App.Network.Room.SoloRoom;
import hidenword.App.Network.Session.Session;
import hidenword.App.Network.Session.SessionService;

/**
 * Packet when a Player want to start a solo game
 * @author Gaëtan
 */
final public class StartSoloGame implements PacketRegistryHandler.PacketHandler {
    final private SessionService service;
    
    public StartSoloGame(SessionService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        StartSoloGameAccept startSoloGameAccept = new StartSoloGameAccept(session);
        Room newSoloRoom = new SoloRoom();
        service.getRooms().add(newSoloRoom);
        session.setRoomId(service.getRooms().indexOf(newSoloRoom));
        Room room = service.getRooms().get(session.getRoomId());
        room.create(session);
        
        session.write(startSoloGameAccept);
    }

    @Override
    public String code() {
        return "SOLO";
    }   
}
