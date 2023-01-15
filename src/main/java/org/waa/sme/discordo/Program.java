package org.waa.sme.discordo;

import org.waa.sme.discordo.Network.TcpHandler;

/**
 * class utilisé pour lancer le programme pour des fins de test/debug
 */
public class Program {
    public static void main(String[] args) throws Exception {
        TcpHandler tcpServer = new TcpHandler(8080);

        tcpServer.start();
    }

}

