import java.io.*;
import java.net.*;

class Hserver {
    public static void main(String args[]){
        int port=8080;
        try(ServerSocket serverSocket = new ServerSocket(port)){
           System.out.println("server is listening on port " + port);
           while(true){
               Socket socket = serverSocket.accept();
               System.out.println("client connected");
               InputStream input = socket.getInputStream();
               BufferedReader reader = new BufferedReader(new InputStreamReader(input));
               String message = reader.readLine();
               System.out.println("recieved from client: "+ message);
               OutputStream output = socket.getOutputStream();
               PrintWriter writer = new PrintWriter(output, true);
               writer.println("hello client");
               socket.close();

               System.out.println("Connection closed");
            } 
        }

        catch(IOException ex){
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}