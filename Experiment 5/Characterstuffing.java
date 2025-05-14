import java.util.Scanner;

public class Characterstuffing {
    public static void main(String[] args) {
        final String Flag = "Flag";
        final String ESC = "ESC";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to send: ");
        String message = sc.nextLine();
        String stuffedData = message.replace(ESC, ESC + ESC).replace(Flag, ESC + Flag);
        String framedData = Flag + stuffedData + Flag;
        System.out.println("Framed data: " + framedData);
        String receivedData = framedData.substring(Flag.length(), framedData.length() -
                Flag.length());
        String destuffedData = receivedData.replace(ESC + Flag, Flag).replace(ESC + ESC, ESC);
        System.out.print("Extracted data: " + destuffedData);
    }
}