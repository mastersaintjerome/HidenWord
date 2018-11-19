package hidenword.App.Network.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

final public class Session implements Runnable{
    public final static char END_OF_PACKET = '\n';
    private final Socket clientSocket;
    private final SessionService sessionService;
    private final SessionHandler handler;
    private PrintWriter writer;
    private boolean running = false;

    public Session(Socket client,SessionService sessionService,SessionHandler handler) {
        this.clientSocket = client;
        this.sessionService = sessionService;
        this.handler = handler;
    }

    @Override
    public void run() {
        running = true;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            
            // Notify to handler that session is started
            handler.started(this);
            Logger.getLogger(Session.class.getName()).log(Level.INFO, "Session {0} is started", this);
            
            StringBuilder packet = new StringBuilder(256);
            char curChar[] = new char[1];
            while ((!isClosed()) && (in.read(curChar, 0, 1) != -1)) {
                if(curChar[0] != END_OF_PACKET) {
                    packet.append(curChar);
                    continue;
                }

                String realPacket = packet.toString().trim();
                if(realPacket.length() > 0) {
                    HandlePacket(realPacket);
                    packet = new StringBuilder(256);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stop();
            handler.stopped(this);
            Logger.getLogger(Session.class.getName()).log(Level.INFO, "Session {0} is stopped", this);
        }	
    }

    private void HandlePacket(String packet) {
        Logger.getLogger(Session.class.getName()).log(Level.INFO, "Received Packet : {0} For session{1}", new Object[]{packet, this});
        handler.received(this, packet); 
    }

    private boolean isClosed() {
        return (this.clientSocket.isClosed() || !running);
    }

    public void stop() {
        running = false;
        sessionService.remove(this);
        try {
            if(!clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Write a packet to the client
     *
     * @param packet Packet to send. Should be an object implementing toString() method
     *
     * @throws IllegalStateException When session is closed
     */
    public void write(Object packet) {
        if (!running) {
            throw new IllegalStateException("Try to write on closed session");
        }

        // Write packet to socket, with packet ending
        Logger.getLogger(Session.class.getName()).log(Level.INFO, "Send packet {0} to session {1}", new Object[]{packet, this});
        writer.write(packet.toString());
        writer.write(END_OF_PACKET);
        writer.flush();
}
}
