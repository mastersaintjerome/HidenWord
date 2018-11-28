/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.Out.AskGamesRoomAnswer;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;
import java.util.Iterator;

/**
 * Packet when a Player ask for room
 * @author Gaëtan
 */
final public class AskGamesRoom implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    /**
     * Constructor of AskGamesRoom packet received
     * @param service
     */
    public AskGamesRoom(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        StringBuilder gamesRoom = new StringBuilder(256);
        for(Iterator it = service.getDuelGameIds().iterator();it.hasNext();){
            gamesRoom.append("[");
            gamesRoom.append(it.next());
            gamesRoom.append("]");
            gamesRoom.append(" 1/2");
            if(it.hasNext()){
               gamesRoom.append(","); 
            }
        }
        AskGamesRoomAnswer message = new AskGamesRoomAnswer(session,gamesRoom.toString());
        session.write(message);
    }

    @Override
    public String code() {
        return "AGROOM";
    }   
}