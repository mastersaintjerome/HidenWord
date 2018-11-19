/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Room;

import hidenword.App.Network.Session.Session;

/**
 * Basic Interface of a Game Room
 * @author Gaëtan
 */
public interface Room {
    
    /**
     * Create a room
     * @param session
     */
    public void create(Session session);
    
    /**
     * Delete a room
     * @param session
     */
    public void remove(Session session);
    
    /**
     * joina a room
     * @param session
     */
    public void join(Session session);
}
