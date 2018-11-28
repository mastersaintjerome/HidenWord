/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Game.Player;
import hidenword.App.Network.Packet.Out.NextTurn;
import hidenword.App.Network.Packet.Out.WaitTurn;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;
import java.util.List;

/**
 * Packet when player start DuelGame (Should answer only to the first player)
 * @author Gaëtan Perrot, Barbaria
 */
final public class StartDuelGame implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public StartDuelGame(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        Player player = service.getPlayer(session);
        List<Player> players = player.getGame().getPlayers();
        if(players.size() == 2){
            //Only for the first player
            if(players.get(0).equals(player)){
                NextTurn nextTurn = new NextTurn(session,player.getSearchWord().toString());
                session.write(nextTurn);
            }else{
                WaitTurn waitTurn = new WaitTurn(session,player.getSearchWord().toString());
                session.write(waitTurn);
            }
        }
    }

    @Override
    public String code() {
        return "SDUEL";
    }   
}