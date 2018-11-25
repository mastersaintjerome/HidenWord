/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameFactory;

import hidenword.App.Game.Game;
import hidenword.App.Game.GameStrategy.DuelTurnStrategy;

/**
 * Create the Duel Game Mode with the strategy 
 * @author Gaëtan
 */
public class DuelGameFactory implements GameFactory{

    /**
     * Return a new DuelGame
     * @return Game
     */
    @Override
    public Game create() {
        return new Game(new DuelTurnStrategy());
    }
    
}
