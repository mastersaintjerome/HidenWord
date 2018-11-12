package hidenword.Utils;

import static hidenword.Constants.Languages.LANGUAGE_EN;
import static hidenword.Constants.Languages.LANGUAGE_FR;
import static hidenword.Constants.Paths.DICOS_DIRECTORY;
import static hidenword.Constants.Paths.DICO_FILENAME_EXTENSION;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * File Processor
 * @author Gaëtan
 */
public class FileProcessor {
    private BufferedReader reader;
    private String dicoFile;
    private String language;
    
    /**
    * Constructor
    * @param language Choosen Language
    */
    public FileProcessor(String language){
        this.language = language;
        selectLanguageFile();
        makeDicoFileStr();
    }
    
    /**
    * Select a language file (dico) (maybe deprecated in futur)
    */
    private void selectLanguageFile(){
        switch(language){
            case "FR" :
                language = LANGUAGE_FR;
                break;
            case "EN" :
                language = LANGUAGE_EN;
                break; 
            default :
                language = LANGUAGE_FR;
                break;
        }
    }
    
    private void makeDicoFileStr(){
        dicoFile = DICOS_DIRECTORY + language + "_dico" + DICO_FILENAME_EXTENSION;
    }
    
    public int getNbLine() throws IOException{
        reader = new BufferedReader(new FileReader(dicoFile));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
    
    public String getLineAtIndex(int index) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(dicoFile));
        String line = null;
        try (LineNumberReader lnr = new LineNumberReader(br)) {
            int lnum = 0;
            while ( ((line = lnr.readLine()) != null ) && ( (lnum = lnr.getLineNumber()) < index) ) {
            }           
            //Start Debug 
            if(lnum == 0){
                System.out.println("the file has zero length");
            }else if(lnum == index){
                System.out.println("line " + index + ": " + line);
            }else{
                System.out.println("the file has only " + lnum + " line(s)");
            }
            //End Debug
        }
        return line;
    }
}