/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App;

import hidenword.App.Network.Server;
import hidenword.App.Network.ServerFactory;

/**
 *  Main of the Server
 * @author Gaëtan
 */
public class HidenWordServer {
     public static void main(String[] args) throws Exception {
        // Get the port from CLI argument
        final int port = args.length > 1 ? Integer.parseInt(args[1]) : 5000;
        
        final ServerFactory factory = new ServerFactory(port);
        final Server server = factory.server();

        // Stop the server
        server.start();

        // Stop properly the server when stop the application
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
    }
}
