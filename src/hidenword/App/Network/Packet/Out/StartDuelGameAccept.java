/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Answer of Packet when a Player want to start a duel game
 * Response for {@link StartDuelGame}
 * @author Gaëtan
 */
final public class StartDuelGameAccept {
    final private Session session;  

    public StartDuelGameAccept(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "DUELA" + session;
    }
}