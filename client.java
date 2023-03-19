import java.net.Socket;
import java.io.*;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    public Client() {
        try {
            System.out.println("Request to server");
            socket = new Socket("117.221.204.206",63381);
            System.out.println("Connection done");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Server terminated the chat");
                        break;
                    }
                    System.out.println("Server: " + msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        System.out.println("Writer started...");
        Runnable r2 = () -> {
            while (true) {
                try {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is client");
        new Client();
    }
}
