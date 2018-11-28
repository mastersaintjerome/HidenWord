/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Answer when client ask for games room
 * @author Gaëtan Perrot, Barbaria
 */
public class AskGamesRoomAnswer {
    final private Session session;
    private final String message;
    
    /**
     * Constructor of AskGamesRoomAnswer packet
     * @param session
     * @param message
     */
    public AskGamesRoomAnswer(Session session,String message) {
        this.session = session;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AGROOMA " + message;
    }
}
