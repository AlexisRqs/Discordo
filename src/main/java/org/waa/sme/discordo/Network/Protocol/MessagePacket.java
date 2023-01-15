package org.waa.sme.discordo.Network.Protocol;

import org.waa.sme.discordo.Network.Protocol.Packet.Packet;
import org.waa.sme.discordo.Network.Protocol.Packet.PacketType;

import java.util.Date;

public class MessagePacket extends Packet {
    private final String sender;
    private final String message;
    private final Date sentAt;

    /**
     * Creates a new message packet
     * @param sender
     * @param message
     */
    public MessagePacket(String sender, String message) {
        super(PacketType.MESSAGE);
        this.sender = sender;
        this.message = message;
        this.sentAt = new Date();
    }

    /**
     * Gets the sender of the message
     * @return
     */
    public String getSender() {
        return sender;
    }

    /**
     * Gets the message
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the date the message was sent
     * @return
     */
    public Date getSentAt() {
        return sentAt;
    }
}
