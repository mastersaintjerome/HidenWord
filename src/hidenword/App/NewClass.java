/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App;

import hidenword.App.Core.File.FileProcessor;
import hidenword.App.Core.Configuration.Properties;
import static hidenword.App.Core.File.Paths.FILE_LOGIN_SCENE_LANGS_NAME;
import static hidenword.App.Core.File.Paths.PATH_CONFFILE;
import static hidenword.App.Core.File.Paths.PATH_LOGIN_SCENE_LANGS;
import static hidenword.App.Core.Configuration.Properties.DICOS_DIRECTORY;
import static hidenword.App.Core.Configuration.Properties.DICO_FILENAME_EXTENSION;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;



/**
 *
 * @author Gaëtan
 */
public class NewClass {
        public static void main(String[] args) throws IOException {
            System.out.println(Properties.DICOS_DIRECTORY);
            System.out.println(DICO_FILENAME_EXTENSION); 
            System.out.println(Configuration.getInstance().getProperty(Properties.DICOS_DIRECTORY));
            
            Locale currentLocale = Locale.getDefault();
            String localeLanguage = currentLocale.getLanguage();
            FileProcessor fileProcessor = new FileProcessor(localeLanguage.toUpperCase());
            int max = fileProcessor.getNbLine();
            Random rand = new Random(); 
            int randNumber = rand.nextInt(max - 0 + 1) + 0;
            String test = fileProcessor.getLineAtIndex(randNumber);
            System.out.println(test);
            
           
            ResourceBundle messages;

            File file = new File(PATH_LOGIN_SCENE_LANGS);
            URL[] urls = new URL[]{file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            
            messages = ResourceBundle.getBundle(FILE_LOGIN_SCENE_LANGS_NAME, currentLocale,loader);
            System.out.println(messages.getString("greetings"));
            System.out.println(messages.getString("inquiry"));
            System.out.println(messages.getString("farewell"));
           
    }
}
