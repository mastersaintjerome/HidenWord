/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Room;

import hidenword.App.Game.Game;
import hidenword.App.Game.GameFactory.DuelGameFactory;
import hidenword.App.Game.GameFactory.GameFactory;
import hidenword.App.Game.Player;
import hidenword.App.Network.Session.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * Room of a duel game
 * @author Gaëtan
 */
final public class DuelRoom implements Room{
    private Map<Session,Player> players = new HashMap();
    private Game game;
    
    @Override
    public void create(Session session) {
        players.put(session, new Player("NotSet"));
        GameFactory gameFactory = new DuelGameFactory();
        game = gameFactory.create();
    }

    @Override
    public void remove(Session session) {
        players.remove(session);
    }

    @Override
    public boolean join(Session session) {
        if(players.size() < 2){
            players.put(session, new Player("NotSet"));
            return true;
        }
        return false;
    }
}
