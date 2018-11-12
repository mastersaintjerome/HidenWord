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
public final class Languages {
    public static final String LANGUAGE_FR = "FR";
    public static final String LANGUAGE_EN = "EN";
    
    private Languages(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}
