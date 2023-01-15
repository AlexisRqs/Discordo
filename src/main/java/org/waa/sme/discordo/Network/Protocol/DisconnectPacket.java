package org.waa.sme.discordo.Network.Protocol;

import org.waa.sme.discordo.Network.Protocol.Packet.Packet;
import org.waa.sme.discordo.Network.Protocol.Packet.PacketType;

public class DisconnectPacket extends Packet {
    private final long userId;

    /**
     * Creates a new disconnect packet
     * @param userId
     */
    public DisconnectPacket(long userId) {
        super(PacketType.DISCONNECT);
        this.userId = userId;
    }

    /**
     * Gets the user id
     * @return
     */
    public long getId() {
        return userId;
    }
}
