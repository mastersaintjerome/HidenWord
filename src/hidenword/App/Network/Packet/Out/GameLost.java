/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Packet Send when player lost
 * @author Gaëtan
 */
public class GameLost {
    final private Session session;

    /**
     * Constructor of GameLost packet
     * @param session
     */
    public GameLost(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "GLOST " + session;
    }
}
