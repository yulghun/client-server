import java.net.*;
import java.io.*;

public class RemoteHelloWorldServer { 
    public void run() {
        try {
	    int serverPort = 8080;
	    ServerSocket serverSocket = new ServerSocket(serverPort);
	    serverSocket.setSoTimeout(300000); 
	    while(true) {
		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "..."); 

		Socket server = serverSocket.accept();
		System.out.println("Accepted connecton on " + server.getRemoteSocketAddress()); 

		PrintWriter toClient = new PrintWriter(server.getOutputStream(), true);
		toClient.println("Hello world!\nFrom: " + server.getLocalSocketAddress()); 
	    }
        }
	catch(UnknownHostException ex) {
	   ex.printStackTrace();
	}
	catch(IOException e){
	   e.printStackTrace();
	}
    }
  
  public static void main(String[] args) {
      RemoteHelloWorldServer srv = new RemoteHelloWorldServer();
      srv.run();
  }
}
