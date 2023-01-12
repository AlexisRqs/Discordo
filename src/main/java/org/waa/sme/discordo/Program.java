package org.waa.sme.discordo;

import org.waa.sme.discordo.Network.TcpHandler;

public class Program {
    public static void main(String[] args) throws Exception {
        /*NatsConsumer consumer = new NatsConsumer("nats://localhost:4222", "messages");

        consumer.publish("messages", "avant abonnement");

        Thread.sleep(2000);

        consumer.start();

        consumer.publish("messages", "après abonnement");

        Thread.sleep(2000);

        System.out.println("Messages: " + consumer.getMessages());*/

        TcpHandler tcpServer = new TcpHandler(8080);

        tcpServer.start();
    }

}

