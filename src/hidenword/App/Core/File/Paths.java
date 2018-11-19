/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Core.File;

/**
 * Files Paths Constants
 * @author Gaëtan
 */
public final class Paths {
    public static final String PATH_CONFFILE = System.getProperty("user.dir")+ "/Resources/config.properties";
    //Debut Internationnalisation
    public static final String PATH_LOGIN_SCENE_LANGS = System.getProperty("user.dir") + "/Resources/Langs/MessagesBundleLoginScene/";
    public static final String FILE_LOGIN_SCENE_LANGS_NAME = "MessagesBundleLoginScene";
    
    public static final String PATH_REGISTER_SCENE_LANGS = System.getProperty("user.dir") + "/Resources/Langs/MessagesBundleRegisterScene/";
    public static final String FILE_REGISTER_SCENE_LANGS_NAME = "MessagesBundleRegisterScene";
    //Fin Internationnalisation
    
    private Paths(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}