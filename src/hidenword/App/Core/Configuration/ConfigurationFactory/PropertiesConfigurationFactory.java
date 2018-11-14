/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Core.Configuration.ConfigurationFactory;

import hidenword.App.Core.Configuration.Configuration;
import hidenword.App.Core.Configuration.PropertiesDriver;

/**
 * Configuration Factory for configuration with properties file
 * @author Gaëtan
 */
final public class PropertiesConfigurationFactory implements ConfigurationFactory{

    @Override
    public Configuration create(String fileName) {
        return new Configuration(new PropertiesDriver(fileName));
    }  
}
