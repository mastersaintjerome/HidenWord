/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameStrategy;

import hidenword.App.Game.Game;

/**
 * Strategy for the duel game mode turn
 * @author Gaëtan Perrot, Barbaria
 */
final public class DuelTurnStrategy implements GameTurnStrategy{

    @Override
    public boolean nextTurn(Game game) {
        return game.playerGameturn(game.getPlayerByPosition());
    }
}
