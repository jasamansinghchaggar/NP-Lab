import java.net.*;

class Hserverudp {
    public static void main(String args[]) {
        int port = 9876;
        try (DatagramSocket ss = new DatagramSocket(port)) {
            System.out.println("Server is listening for messages");
            byte[] receiveBuffer = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                ss.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(
                        "Received from" + receivePacket.getAddress() + ":" + receivePacket.getPort() + "=>" + message);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}