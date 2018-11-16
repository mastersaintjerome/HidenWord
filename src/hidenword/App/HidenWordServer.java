/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App;

/**
 *  Main of the Server
 * @author Gaëtan
 */
public class HidenWordServer {
     public static void main(String[] args) throws Exception {
        // Get the port from CLI argument
        final int port = args.length > 1 ? Integer.parseInt(args[1]) : 5000;

    }
}
