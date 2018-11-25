/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Game.GameFactory;

import hidenword.App.Game.Game;

/**
 * GameFactory is an Interface to create the correct Game Mode
 * @author Gaëtan
 */
public interface GameFactory {

    /**
     * Create a new Game
     * @return Game
     */
    public Game create();
}
