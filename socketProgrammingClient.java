import java.io.*;
import java.net.*;

class Hclient {
    public static void main(String args[]){
        String hostnme = "127.0.0.1";
        int port = 8080;
        try(Socket socket = new Socket(hostnme, port)){
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("hello Server");
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message = reader.readLine();
            System.out.println("recieved from server: "+ message);
        }
        catch(UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
        catch(IOException ex){
            System.out.println("i/o error: " + ex.getMessage());
        }
    }
}