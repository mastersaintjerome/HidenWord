/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Core.Configuration.ConfigurationFactory;

import hidenword.App.Core.Configuration.Configuration;

/**
 * Base Interface for Configuration Factory
 * @author Gaëtan
 */
public interface ConfigurationFactory {

    /**
     * Create a configuration
     * @param fileName
     * @return Configuration
     */
    public Configuration create(String fileName);
}
