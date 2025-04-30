import java.net.*;

class Hclientudp {
    public static void main(String args[]) {
        final String Seraddress = "localhost";
        final int Serport = 9876;
        try (DatagramSocket client = new DatagramSocket()) {
            String message = "Hello, Server from client 1";
            byte[] senddata = message.getBytes();
            InetAddress serveraddress = InetAddress.getByName(Seraddress);
            DatagramPacket sendPacket = new DatagramPacket(senddata, senddata.length, serveraddress, Serport);
            client.send(sendPacket);
            System.out.println("Message sent to server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}