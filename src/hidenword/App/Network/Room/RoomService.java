/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Room;

import hidenword.App.Network.Session.Session;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Gaëtan
 */
public class RoomService {
    final private ArrayList<Room> rooms = new ArrayList();
    final private Logger logger;

    public RoomService(){
        logger = Logger.getLogger(RoomService.class.getName());
    }
    
    public Room createSoloRoom(Session session){
        logger.info("New room created : ");
        return null;
    }
    
    public Room createDuelROom(Session session){
        logger.info("New room created : ");
        return null;
    }
    
    /**
     * Remove a room
     * @param room
     */
    public void remove(Room room) {
        this.rooms.remove(room);
        logger.info("Room destroyed !");
    }
    
    public Room getRoom(int index){
        return rooms.get(index);
    }
    
    /**
     *
     * @return all rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}