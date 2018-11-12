/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.Utils;

import static hidenword.Constants.Paths.PATH_CONFFILE;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaëtan
 */
public class Configuration {
    private Properties properties = null;
    private static Configuration instance = null;
    
    /** Private constructor */
    private Configuration (){
        this.properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(PATH_CONFFILE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            properties.load(file);
            file.close();
        }catch(Exception ex){
            ex.printStackTrace();        
        }
    } 
    
    /** Creates the instance is synchronized to avoid multithreads problems */
    private synchronized static void createInstance () {
        if (instance == null) { 
            instance = new Configuration ();
        }
    }
    
    /** Get the properties instance. Uses singleton pattern */
    public static Configuration getInstance(){
        // Uses singleton pattern to guarantee the creation of only one instance
        if(instance == null) {
            createInstance();
        }
        return instance;
    }
    
    /** Get a property of the property file */
    public String getProperty(String key){
        String result = null;
        
        StringWriter writer = new StringWriter();
  this.properties.list(new PrintWriter(writer));
   System.out.println(writer.getBuffer().toString());
        
        if(key !=null && !key.trim().isEmpty()){
            result = this.properties.getProperty(key);
        }
        return result;
    }
    
    /** Override the clone method to ensure the "unique instance" requeriment of this class */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}




  







