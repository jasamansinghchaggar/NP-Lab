import java.io.*;
import java.net.*;

class Server{
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serversocket = new ServerSocket(port, 50, InetAddress.getByName("0.0.0.0"))) {
            System.out.println("Server is listening at port " + port);
            while (true) {
                Socket clientSocket = serversocket.accept();
                System.out.println("New client connection: " + clientSocket.getInetAddress());
                String clientIp = clientSocket.getInetAddress().getHostAddress();
                new ClientHander(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHander extends Thread {
    private Socket socket;
    public ClientHander(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try (
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            PrintWriter writer = new PrintWriter(out, true); 
        ) {
            String message;
            while((message = reader.readLine()) != null){
                System.out.println("[Received]" + message);
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
                System.out.println("client disconnect");
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}