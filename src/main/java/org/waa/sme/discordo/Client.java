package org.waa.sme.discordo;

import org.waa.sme.discordo.Network.TCPClient;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        TCPClient tcpClient = new TCPClient("127.0.0.1", 8080);
        tcpClient.start();
    }
}
