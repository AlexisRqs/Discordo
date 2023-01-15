package org.waa.sme.discordo.Network.Protocol;

import org.waa.sme.discordo.Network.Protocol.Packet.Packet;
import org.waa.sme.discordo.Network.Protocol.Packet.PacketType;

public class FileMessagePacket extends Packet {
    private final String fileName;
    private final byte[] fileData;

    public FileMessagePacket(String sender, String message, String fileName, byte[] fileData) {
        super(PacketType.FILE);
        this.fileName = fileName;
        this.fileData = fileData;
    }

    /**
     * Gets the file name
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the file data
     * @return
     */
    public byte[] getFileData() {
        return fileData;
    }
}
