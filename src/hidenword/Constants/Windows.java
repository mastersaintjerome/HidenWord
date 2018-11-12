/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.Constants;

/**
 *
 * @author Gaëtan
 */
public final class Windows {
    public static final String APP_NAME = "HidenWord";
    public static final double LOGIN_SCENE_WIDTH = 500;
    public static final double LOGIN_SCENE_HEIGHT = 400;
    
    public static final double REGISTER_SCENE_WIDTH = 500;
    public static final double REGISTER_SCENE_HEIGHT = 400;
    
    public static final double GAME_SCENE_WIDTH = 500;
    public static final double GAME_SCENE_HEIGHT = 400;
    
    private Windows(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}
