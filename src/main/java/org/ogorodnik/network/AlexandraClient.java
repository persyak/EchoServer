package org.ogorodnik.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AlexandraClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("privet".getBytes());

        byte[] clientBuffer = new byte[50];
        InputStream inputStream = socket.getInputStream();
        int clientCount = inputStream.read(clientBuffer);
        System.out.println(new String(clientBuffer, 0, clientCount));
    }
}
