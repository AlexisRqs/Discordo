package org.waa.sme.discordo.Network;

import java.net.Socket;

public class TcpConnection {
    private final Socket socket;

    public TcpConnection(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
