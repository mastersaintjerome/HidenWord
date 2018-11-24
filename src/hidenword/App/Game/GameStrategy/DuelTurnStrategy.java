/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameStrategy;

import hidenword.App.Game.Game;

/**
 * Strategy for the duel game mode turn
 * @author Gaëtan
 */
final public class DuelTurnStrategy implements GameTurnStrategy{

    @Override
    public void nextTurn(Game game) {
        if(game.getTurnCounter()%2 == 0){
            game.playerGameturn(game.getPlayers().get(0));
        }
        if(game.getTurnCounter()%2 == 1){ 
            game.playerGameturn(game.getPlayers().get(1));
        }
    }
}
