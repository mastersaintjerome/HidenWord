/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network.Packet.In;

import hidenword.App.Game.GameService;
import hidenword.App.Game.Player;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.Session;

/**
 * Packet when a Player send a Char after play his turn
 * @author Gaëtan
 */
final public class GameTurnCharReceived implements PacketRegistryHandler.PacketHandler {
    final private GameService service;
    
    public GameTurnCharReceived(GameService service) {
        this.service = service;
    }
    
    @Override
    public void handle(Session session, String packet) {
        String[] parts = packet.split(" ", 2);
        String receivedChar = parts[1];

    }

    @Override
    public String code() {
        return "GTCR";
    }   
}