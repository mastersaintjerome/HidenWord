/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.Model.Game.GameStrategy;

import hidenword.Model.Game.Game;

/**
 * Strategy for the duel game mode turn
 * @author Gaëtan
 */
final public class DuelTurnStrategy implements GameTurnStrategy{

    @Override
    public void nextTurn(Game game) {
        game.playerGameturn(game.getPlayers()[0]);
        game.playerGameturn(game.getPlayers()[1]);
    }
}
