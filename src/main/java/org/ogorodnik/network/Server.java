package org.ogorodnik.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        boolean isOver = false;

        ServerSocket serverSocket = new ServerSocket(3000);
        //listen

        while (!isOver) {

            byte[] serverBuffer = new byte[50];
            try (Socket socket = serverSocket.accept();
                 InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {
                int serverCount = inputStream.read(serverBuffer);
                String messageFromClient = "Echo " + new String(serverBuffer, 0, serverCount);
                outputStream.write(messageFromClient.getBytes());
            }
        }
    }
}
