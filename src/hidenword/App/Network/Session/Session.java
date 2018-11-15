package Session;

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
	private Socket clientSocket;
	private SessionService sessionService;
	private SessionHandler handler;
	private PrintWriter writer;
	private boolean running = false;
	
	public Session(Socket client,SessionService sessionService,SessionHandler handler) {
		this.clientSocket = client;
		this.sessionService = sessionService;
	}
	
	@Override
	public void run() {
		running = true;
        try {
        	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        	writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
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
        } catch (Exception ex) {
        	Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        	stop();
        }	
	}
	
	private void HandlePacket(String packet) {
		Logger.getLogger(Session.class.getName()).info("Received Packet : " + packet + " For session" + this);
		handler.receive(this, packet);
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
}
