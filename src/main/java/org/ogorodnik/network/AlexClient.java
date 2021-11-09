package org.ogorodnik.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AlexClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);

        try (OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream()) {
            outputStream.write("Hello".getBytes());
            byte[] clientBuffer = new byte[50];
            int clientCount = inputStream.read(clientBuffer);
            System.out.println(new String(clientBuffer, 0, clientCount));
        }
    }
}
