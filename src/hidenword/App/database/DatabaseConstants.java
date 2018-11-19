/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.database;

/**
 * Database Constants
 * @author Gaëtan
 */
public final class DatabaseConstants {

    /**
     * URL for the database
     */
    public final static String CONNECT_URL = "jdbc:sqlite:Data/db/hiden-word.db";
    
    private DatabaseConstants(){
        //this prevents even the native class from 
        //calling this constructor as well :
        throw new AssertionError();
    }
}
