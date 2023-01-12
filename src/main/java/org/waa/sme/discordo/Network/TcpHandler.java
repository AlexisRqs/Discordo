package org.waa.sme.discordo.Network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.waa.sme.discordo.Network.Protocol.MessagePacket;
import org.waa.sme.discordo.Network.Protocol.Packet.EncoderPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpHandler {
    private final int PORT;
    private final ExecutorService executor;
    private Map<Long, Socket> clients;
    private static final Logger logger = LoggerFactory.getLogger(TcpHandler.class);

    public TcpHandler(int port) {
        this.PORT = port;
        this.executor = Executors.newCachedThreadPool();
        this.clients = Collections.synchronizedMap(new HashMap<>());
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                executor.execute(() -> {
                    try {
                        handleConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private void handleConnection(Socket clientSocket) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String inputLine;
            EncoderPacket encoderPacket = new EncoderPacket();
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            while ((inputLine = in.readLine()) != null) {
                logger.info(String.format("Received: {0}", inputLine));
                String response = stdIn.readLine();
                MessagePacket messagePacket = new MessagePacket("SERVER", response);
                out.println(encoderPacket.encode(messagePacket));
            }
        }
    }
}
