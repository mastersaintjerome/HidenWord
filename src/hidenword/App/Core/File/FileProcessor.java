package hidenword.App.Core.File;

import hidenword.App.Core.Configuration.Configuration;
import hidenword.App.Core.Configuration.ConfigurationFactory.ConfigurationFactory;
import hidenword.App.Core.Configuration.ConfigurationFactory.PropertiesConfigurationFactory;
import hidenword.App.Core.Configuration.Properties;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * File Processor
 * @author Gaëtan Perrot, Barbaria
 */
public class FileProcessor {
    private BufferedReader reader;
    private String dicoFile;
    private String language;

    /**
     * Constant dicos directory path
     */
    final public String DICOS_DIRECTORY;

    /**
     * Constant dicos extension
     */
    final public String DICO_FILENAME_EXTENSION;
    
    /**
    * Constructor
    * @param language Choosen Language
    */
    public FileProcessor(String language){
        ConfigurationFactory propertiesConfigurationFactory = new PropertiesConfigurationFactory();
        Configuration config = propertiesConfigurationFactory.create(Paths.PATH_CONFFILE);
        DICOS_DIRECTORY = config.get(Properties.DICOS_DIRECTORY);
        DICO_FILENAME_EXTENSION = config.get(Properties.DICO_FILENAME_EXTENSION);
        this.language = language;
        makeDicoFileStr();
    }
    
    private void makeDicoFileStr(){
        dicoFile = DICOS_DIRECTORY + language + "_dico" + DICO_FILENAME_EXTENSION;
    }
    
    /**
     * get the number of line
     * @return Nb line
     * @throws IOException
     */
    public int getNbLine() throws IOException{
        reader = new BufferedReader(new FileReader(dicoFile));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
    
    /**
     * Return the line at the index of the dico File
     * @param index
     * @return The line at the index
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getLineAtIndex(int index) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(dicoFile));
        String line = null;
        try (LineNumberReader lnr = new LineNumberReader(br)) {
            int lnum = 0;
            while ( ((line = lnr.readLine()) != null ) && ( (lnum = lnr.getLineNumber()) < index) ) {
            }           
        }
        return line;
    }
}