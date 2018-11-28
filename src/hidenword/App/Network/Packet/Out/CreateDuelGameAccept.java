/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * Answer of Packet when a Player want to create a duel game
 * Response for {@link CreateDuelGame}
 * @author Gaëtan Perrot, Barbaria
 */
final public class CreateDuelGameAccept {
    final private Session session;  

    public CreateDuelGameAccept(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "DUELA " + session;
    }
}