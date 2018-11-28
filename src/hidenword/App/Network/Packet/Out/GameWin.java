/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Packet Send when player win
 * @author Gaëtan Perrot, Barbaria
 */
public class GameWin {
    final private Session session;
    private final String word;
    
    /**
     * Constructor of GameWin packet
     * @param session
     */
    public GameWin(Session session,String word) {
        this.session = session;
        this.word = word;
    }

    @Override
    public String toString() {
        return "GWIN " + word;
    }
}
