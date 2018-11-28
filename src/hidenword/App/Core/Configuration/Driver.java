/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Core.Configuration;

/**
 * Base Interface for Driver file for configuration using
 * @author Gaëtan Perrot, Barbaria
 */
public interface Driver {
    /**
     * Check if the configuration has the key
     * @param key Configuration item to check
     * @return boolean
     */
    public boolean has(String key);

    /**
     * Get the value of the item
     * @param key The config item key
     * @return The raw value
     */
    public String get(String key);
}
