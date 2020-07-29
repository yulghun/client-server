import java.io.*;
import java.net.*;

public class HelloWorldClient {
    public void run() {
	try {
	    int serverPort = 8080;

	    InetAddress host = InetAddress.getByName("your IP address"); 
	    System.out.println("Connecting to server on port " + serverPort); 

	    Socket socket = new Socket(host, serverPort); 
	    System.out.println("Just connected to remote server  " + socket.getRemoteSocketAddress()); 
	    BufferedReader fromServer = new BufferedReader( new InputStreamReader(socket.getInputStream()));
	    String line = fromServer.readLine();
	    System.out.println("Client received: " + line + " from Server");
	    fromServer.close();
	    socket.close();
	}
	catch(UnknownHostException ex) {
	    ex.printStackTrace();
	}
	catch(IOException e){
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
      HelloWorldClient client = new HelloWorldClient();
      client.run();
    }
}
