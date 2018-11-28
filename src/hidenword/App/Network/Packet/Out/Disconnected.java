/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 * A session is stopped
 * @author Gaëtan Perrot, Barbaria
 */
final public class Disconnected {
    final private Session session;

    public Disconnected(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "STOPPED " + session;
    }
}