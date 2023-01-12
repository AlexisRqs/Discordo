package org.waa.sme.discordo.Network.Protocol;

import org.waa.sme.discordo.Network.Protocol.Packet.Packet;
import org.waa.sme.discordo.Network.Protocol.Packet.PacketType;

import java.util.Date;

public class MessagePacket extends Packet {
    private final String sender;
    private final String message;
    private final Date sentAt;

    public MessagePacket(String sender, String message) {
        super(PacketType.MESSAGE);
        this.sender = sender;
        this.message = message;
        this.sentAt = new Date();
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Date getSentAt() {
        return sentAt;
    }
}
