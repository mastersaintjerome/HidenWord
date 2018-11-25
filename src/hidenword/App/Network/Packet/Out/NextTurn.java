/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Packet tell client it's his turn
 * @author Gaëtan
 */
public class NextTurn {
    final private Session session;  

    /**
     * Constructor of NextTurn
     * @param session
     */
    public NextTurn(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "PLAY " + session;
    }
}
