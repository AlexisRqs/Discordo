package org.waa.sme.discordo.Network.Protocol;

import org.waa.sme.discordo.Network.Protocol.Packet.Packet;
import org.waa.sme.discordo.Network.Protocol.Packet.PacketType;

public class DisconnectPacket extends Packet {
    private final long userId;

    public DisconnectPacket(long userId) {
        super(PacketType.DISCONNECT);
        this.userId = userId;
    }

    public long getId() {
        return userId;
    }
}
