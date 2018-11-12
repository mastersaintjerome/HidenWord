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
public final class Database {
    public final static String CONNECT_URL = "jdbc:sqlite:Data/db/hiden-word.db";
    
    private Database(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}
