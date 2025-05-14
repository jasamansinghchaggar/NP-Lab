import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

class ServerMultiplexed {
    public static void main(String args[]) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serchannel = ServerSocketChannel.open();
        serchannel.bind(new InetSocketAddress(5000));
        serchannel.configureBlocking(false);
        serchannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Srerver started on port 5000...");
        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey Key = keys.next();
                keys.remove();
                if (Key.isAcceptable()) {
                    ServerSocketChannel srv = (ServerSocketChannel) Key.channel();
                    SocketChannel client = srv.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("New client connected:" + client.getRemoteAddress());
                }
                if (Key.isReadable()) {
                    SocketChannel client = (SocketChannel) Key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesread = client.read(buffer);
                    if (bytesread == -1) {
                        System.out.println("Client disconnected:" + client.getRemoteAddress());
                        client.close();
                        Key.cancel();
                        continue;
                    }
                    buffer.flip();
                    String message = new String(buffer.array(), 0, buffer.limit());
                    System.out.println("Received :" + message);
                    buffer.rewind();
                    client.write(buffer);
                }
            }
        }
    }
}