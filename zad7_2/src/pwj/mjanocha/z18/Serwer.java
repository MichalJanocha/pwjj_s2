package pwj.mjanocha.z18;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(9696);
            while (true) {
                Socket polaczenie = server.accept();
                Thread t = new Thread(
                        new Gracz(polaczenie));
                t.start();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
