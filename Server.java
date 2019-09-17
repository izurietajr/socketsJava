
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Date;

public class Server {
    public ServerSocket server;
    public Socket socket;
    public int port;

    public Server(int port){
        this.port = port;
    }

    public void startServer(){
        try {
            server = new ServerSocket(this.port);
            System.out.println("server running");
            while(true){
                socket = server.accept();
                Date date = new Date();
                PrintStream output = new PrintStream(socket.getOutputStream());
                output.println(date.toString());
            }
        } catch (Exception e) { }
    }

    public static void main(String[] args) {
        Server server = new Server(Integer.parseInt(args[0]));
        server.startServer();
    }

}