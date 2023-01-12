package org.waa.sme.discordo.Network;

import org.waa.sme.discordo.Network.Protocol.DisconnectPacket;
import org.waa.sme.discordo.Network.Protocol.MessagePacket;
import org.waa.sme.discordo.Network.Protocol.Packet.EncoderPacket;
import org.waa.sme.discordo.Network.Protocol.Packet.Packet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPClient {
    private final String host;
    private final int port;

    private static final Logger logger = Logger.getAnonymousLogger();

    public TCPClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            EncoderPacket encoderPacket = new EncoderPacket();
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                try {
                    Packet decode = encoderPacket.decode(response);
                    logger.info(String.format("Received: %s", decode));

                    if (decode instanceof MessagePacket) {
                        MessagePacket messagePacket = (MessagePacket) decode;
                        logger.info(String.format("From: %s", messagePacket.getSender()));
                        logger.info(String.format("Content: %s", messagePacket.getMessage()));
                        logger.info(String.format("Sent at: %s", messagePacket.getSentAt()));
                    }

                    if (decode instanceof DisconnectPacket) {
                        DisconnectPacket messagePacket = (DisconnectPacket) decode;
                        logger.info(String.format("Received: %s", messagePacket.getId()));
                    }

                } catch (ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
