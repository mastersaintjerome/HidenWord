/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network;

import hidenword.App.Game.GameService;
import hidenword.App.Network.Packet.In.AskGamesRoom;
import hidenword.App.Network.Packet.In.CreateDuelGame;
import hidenword.App.Network.Packet.In.GameTurnCharReceived;
import hidenword.App.Network.Packet.In.JoinDuelGame;
import hidenword.App.Network.Packet.In.SessionClosed;
import hidenword.App.Network.Packet.In.SessionStarted;
import hidenword.App.Network.Packet.In.StartDuelGame;
import hidenword.App.Network.Packet.In.StartSoloGame;
import hidenword.App.Network.Packet.PacketRegistryHandler;
import hidenword.App.Network.Session.SessionService;

/**
 * Factory for all the server system
 */
final public class ServerFactory {
    /** The server port */
    final private int port;

    // Store instance to ensure that only one instance is created
    private SessionService sessions;
    private Server server;
    private GameService gameService;

    public ServerFactory(int port) {
        this.port = port;
    }

    /**
     * Create the session service
     */
    public SessionService sessions() {
        gameService = gameService();
        if (sessions == null) {
            PacketRegistryHandler packets = new PacketRegistryHandler(new PacketRegistryHandler.PacketHandler[]{
                // @todo Set the input packets here
                new SessionStarted()
            });

            sessions = new SessionService(packets);

            // @todo register packets which required the session service
            packets.register(new SessionClosed(sessions));
            packets.register(new StartSoloGame(gameService)); 
            packets.register(new CreateDuelGame(gameService));
            packets.register(new JoinDuelGame(gameService));
            packets.register(new StartDuelGame(gameService));
            packets.register(new GameTurnCharReceived(gameService));
            packets.register(new AskGamesRoom(gameService));
        }

        return sessions;
    }
    
    public GameService gameService(){
        if(gameService == null){
            gameService = new GameService();
        }      
        return gameService;
    }
    
    /**
     * Create the server instance
     */
    public Server server() {
        if (server == null) {
            server = new Server(port, sessions(),gameService);
        }
        return server;
    }
}