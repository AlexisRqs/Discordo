package org.waa.sme.discordo.Network;

import org.waa.sme.discordo.Network.Protocol.DisconnectPacket;
import org.waa.sme.discordo.Network.Protocol.FileMessagePacket;
import org.waa.sme.discordo.Network.Protocol.MessagePacket;
import org.waa.sme.discordo.Network.Protocol.Packet.EncoderPacket;
import org.waa.sme.discordo.Network.Protocol.Packet.Packet;

import java.io.*;
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

    /**
     * Start the client
     * @throws IOException
     */
    public void start() throws IOException {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            EncoderPacket encoderPacket = new EncoderPacket();
            while ((userInput = stdIn.readLine()) != null && userInput.equals("message")) {
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
                        DisconnectPacket disconnectPacket = (DisconnectPacket) decode;
                        logger.info(String.format("Received: %s", disconnectPacket.getId()));
                    }

                    if (decode instanceof FileMessagePacket) {
                        FileMessagePacket fileMessagePacket = (FileMessagePacket) decode;
                        logger.info(String.format("Filename: %s", fileMessagePacket.getFileName()));
                        logger.info(String.format("Content length: %s", fileMessagePacket.getFileData().length));

                        writeFiles(fileMessagePacket.getFileName(), fileMessagePacket.getFileData());
                    }

                } catch (ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            while ((userInput = stdIn.readLine()) != null && userInput.equals("file")) {

                String fileName = stdIn.readLine();
                try (
                        FileInputStream fis = new FileInputStream(fileName);
                        OutputStream os = socket.getOutputStream();
                ) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    System.out.println("File sent successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Write file to disk
     * @param fileName
     * @param fileData
     */
    private void writeFiles(String fileName, byte[] fileData) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
