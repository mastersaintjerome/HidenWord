/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.Model.Game.GameFactory;

import hidenword.Model.Game.Game;
import hidenword.Model.Game.GameStrategy.DuelTurnStrategy;

/**
 * Create the Duel Game Mode with the strategy 
 * @author Gaëtan
 */
public class DuelGameFactory implements GameFactory{

    @Override
    public Game create() {
        return new Game(new DuelTurnStrategy());
    }
    
}
