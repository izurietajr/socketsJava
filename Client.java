import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public Socket socket;
    public int port;
    public String host;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
        } catch (Exception e) { }
    }

    public void getServer(){
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            System.out.println(buffer.readLine());
        } catch (Exception e) { }
    }

    public static void main(String[] args) {
       Server client = new Server(args[0], Integer.parseInt(args[1]));
       client.getServer();
    }

}