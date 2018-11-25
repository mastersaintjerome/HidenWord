/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameStrategy;

import hidenword.App.Game.Game;

/**
 * GameTurnStrategy is an interface to use the correct nextTurn() opperation
 * @author Gaëtan
 */
public interface GameTurnStrategy {
    public boolean nextTurn(Game game);
}
