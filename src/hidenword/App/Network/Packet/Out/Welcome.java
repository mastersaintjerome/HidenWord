/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.Out;

import hidenword.App.Network.Session.Session;

/**
 *
 * @author Gaëtan
 */
/**
 * Response for {@link SessionStarted}
 * Welcome packet
 */
final public class Welcome {
    final private Session session;

    public Welcome(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "WELCOME " + session;
    }
}
