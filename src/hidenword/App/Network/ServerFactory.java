/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network;

import hidenword.App.Network.Packet.In.Echo;
import hidenword.App.Network.Packet.In.JoinDuelGame;
import hidenword.App.Network.Packet.In.SessionClosed;
import hidenword.App.Network.Packet.In.SessionStarted;
import hidenword.App.Network.Packet.In.StartDuelGame;
import hidenword.App.Network.Packet.In.StartSoloGame;
import hidenword.App.Network.Packet.In.Stop;
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

    public ServerFactory(int port) {
        this.port = port;
    }

    /**
     * Create the session service
     */
    public SessionService sessions() {
        if (sessions == null) {
            PacketRegistryHandler packets = new PacketRegistryHandler(new PacketRegistryHandler.PacketHandler[]{
                // @todo Set the input packets here
                new Echo(),
                new Stop(),
                new SessionStarted()
            });

            sessions = new SessionService(packets);

            // @todo register packets which required the session service
            packets.register(new SessionClosed(sessions));
            packets.register(new StartSoloGame(sessions)); 
            packets.register(new StartDuelGame(sessions));
            packets.register(new JoinDuelGame(sessions));
        }

        return sessions;
    }

    /**
     * Create the server instance
     */
    public Server server() {
        if (server == null) {
            server = new Server(port, sessions());
        }
        return server;
    }
}