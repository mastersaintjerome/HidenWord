/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game;

import hidenword.App.Game.GameFactory.DuelGameFactory;
import hidenword.App.Game.GameFactory.GameFactory;
import hidenword.App.Game.GameFactory.SoloGameFactory;
import hidenword.App.Network.Session.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Handle all game
 * @author Gaëtan
 */
public class GameService {
    final private int MAXTRY = 15;
    final private Map<Session,Player> players = new HashMap();
    final private List<Game> games = new ArrayList();
    final private Logger logger; 
    GameFactory gameFactory;
    
    public GameService(){
        logger = Logger.getLogger(GameService.class.getName());
    }
    
    public void create(Session session, boolean duel){
        if(duel){
            gameFactory = new DuelGameFactory();
        }else if(!duel){
            gameFactory = new SoloGameFactory();
        }
        Game game = gameFactory.create();
        Player player = new Player("P1");
        player.setGame(game);
        player.setSession(session);
        players.put(session, player);
        session.setPlayer(player);
        List<Player> gamePlayers = new ArrayList();
        gamePlayers.add(player);
        game.init(gamePlayers, MAXTRY);
        games.add(game);
    }
    
    public Game getGame(Session session){
        return players.get(session).getGame();
    }
    
    public void remove(Session session){
        players.remove(session);
    }
    
    public void close(){
        for(Map.Entry<Session, Player> entry : players.entrySet()){
            entry.setValue(null);
        }
        players.clear();
        games.clear();
    }
    
    /**
     * join a a room
     * @param session
     * @return true if it works false if not
     */
    public boolean join(Session session,int gameId){
        if(gameId < games.size() && gameId >= 0){
            Player player = new Player("P2");
            player.setSession(session);
            players.put(session, player);
            session.setPlayer(player);
            return games.get(gameId).addPlayer(player);
        }
        return false;
    }
}
