/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.App.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaëtan
 */
class ClientServerService implements Runnable{
    private Socket clientSocket;
    private int clientID = -1;
    private BufferedReader   in = null;
    private PrintWriter   out = null;
    private boolean running = true;

  ClientServerService(Socket clientSocket, int clientID) {
    this.clientSocket = clientSocket;
    this.clientID = clientID;
  }

    @Override
    public void run() {
        /*
        System.out.println("Accepted Client : ID - " + clientID + " : Address - "
            + clientSocket.getInetAddress().getHostName());
        BufferedReader   in = null;
        PrintWriter   out = null;
        try {
          in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
          while (running) {
            String clientCommand = in.readLine();
            System.out.println("Client Says :" + clientCommand);
            if (clientCommand.equalsIgnoreCase("quit")) {
              running = false;
              System.out.print("Stopping client thread for client : " + clientID);
            } else {
              out.println(clientCommand);
              out.flush();
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }finally{
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
    }
}