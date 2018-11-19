/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConstants Connection
 * @author Gaëtan
 */
public class Database {
    public final static String CONNECT_URL = "jdbc:sqlite:Data/db/hiden-word.db";
    private static Database instance = null;
    private static Connection connection = null;

    /**
    * Constructor
    */
    private Database() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONNECT_URL, "jdbc", "");
            conn.setAutoCommit(false);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.exit(0);
        }
        connection = conn;
    }
        
    /**
    * createInstance : Creates the instance of database
    * Creates the instance is synchronized to avoid multithreads problems
    */
    private synchronized static void createInstance () {
        if (instance == null) { 
            instance = new Database ();
        }
    }
    
    /**
    * Get the database instance. Uses singleton pattern
    * @return DatabaseConstants.
    */
    public static Database getInstance(){
        // Uses singleton pattern to guarantee the creation of only one instance
        if(instance == null) {
            createInstance();
        }
        return instance;
    }

    /** Override the clone method to ensure the "unique instance" requeriment of this class
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
    * Get the Connection.
    * @return Connection.
    */
    public Connection getConnection() {
        return connection;
    }
}