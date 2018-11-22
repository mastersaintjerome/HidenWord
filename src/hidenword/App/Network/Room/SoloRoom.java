/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Room;

import hidenword.App.Game.Game;
import hidenword.App.Game.GameFactory.GameFactory;
import hidenword.App.Game.GameFactory.SoloGameFactory;
import hidenword.App.Game.Player;
import hidenword.App.Network.Session.Session;

/**
 * Room of a solo game
 * @author Gaëtan
 */
final public class SoloRoom implements Room{
    Session session;
    Player player;
    private Game game;
    
    @Override
    public void create(Session session) {
        this.session = session;
        GameFactory gameFactory = new SoloGameFactory();
        game = gameFactory.create();
    }

    @Override
    public void remove(Session session) {
        this.session = null;
    }

    @Override
    public boolean join(Session session) {
        this.session = session;
        return true;
    }
}
