package org.waa.sme.discordo.Network.Protocol.Packet;

import java.io.*;
import java.util.Base64;

public class EncoderPacket {

    /**
     * Encodes a packet to a string
     * @param packet
     * @return
     * @throws IOException
     */
    public String encode(Packet packet) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);

        out.writeObject(packet);
        return Base64.getEncoder().encodeToString(byteOut.toByteArray());
    }

    /**
     * Decodes a packet from a string
     * @param encodedPacket
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Packet decode(String encodedPacket) throws IOException, ClassNotFoundException {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPacket);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(decodedBytes);
        ObjectInputStream in = new ObjectInputStream(byteIn);
        Packet myDecodedObj = (Packet) in.readObject();

        if (myDecodedObj == null) {
            throw new IOException("Decoded object is null");
        }

        if (myDecodedObj.getType() == null) {
            throw new IOException("Decoded object type is null");
        }

        if (myDecodedObj.getType() == PacketType.MESSAGE) {
            return myDecodedObj;
        } else if (myDecodedObj.getType() == PacketType.DISCONNECT) {
            return myDecodedObj;
        } else {
            throw new IOException("Decoded object type is not valid");
        }
    }
}
