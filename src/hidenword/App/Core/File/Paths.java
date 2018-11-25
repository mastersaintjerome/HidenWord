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

    /**
     * PATH_CONFFILE , the path of the config file
     */
    public static final String PATH_CONFFILE = System.getProperty("user.dir")+ "/Resources/config.properties";
    
    private Paths(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}
