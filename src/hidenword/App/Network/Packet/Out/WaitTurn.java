/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Packet tell client wait his turn
 * @author Gaëtan
 */
public class WaitTurn {
    final private Session session;  
    final private String searchWord;
    /**
     * Constructor of NextTurn
     * @param session
     * @param searchWOrd
     */
    public WaitTurn(Session session,String searchWord) {
        this.session = session;
        this.searchWord = searchWord;
    }

    @Override
    public String toString() {
        return "WAITT " + searchWord;
    }
}
