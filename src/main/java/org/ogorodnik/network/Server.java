package org.ogorodnik.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        //listen
        while (true) {
            Socket socket = serverSocket.accept();

            byte[] serverBuffer = new byte[50];
            InputStream inputStream = socket.getInputStream();
            int serverCount = inputStream.read(serverBuffer);
            String messageFromClient = "Echo " + new String(serverBuffer, 0, serverCount);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(messageFromClient.getBytes());
        }
    }
}
