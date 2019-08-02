package Lesson_6.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    Vector<ClientHandler> clients;

    public Server() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Server is running!");
            while (true) {
                socket = server.accept();
                clients.add(new ClientHandler(this, socket));
                System.out.println("Client connected!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void broadcastMessage(String message) {
        for (ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }
}
