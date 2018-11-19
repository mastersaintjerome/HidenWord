/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameStrategy;

import hidenword.App.Game.Game;

/**
 * Strategy for the solo game mode turn
 * @author Gaëtan
 */
final public class SoloTurnStrategy implements GameTurnStrategy{

    @Override
    public void nextTurn(Game game) {
        game.playerGameturn(game.getPlayers()[0]);
    }
}
