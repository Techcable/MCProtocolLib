package org.spacehq.mcprotocol.standard.packet;

import org.spacehq.mcprotocol.event.PacketVisitor;
import org.spacehq.mcprotocol.net.io.NetInput;
import org.spacehq.mcprotocol.net.io.NetOutput;
import java.io.IOException;

import org.spacehq.mcprotocol.net.Client;
import org.spacehq.mcprotocol.net.ServerConnection;
import org.spacehq.mcprotocol.packet.Packet;

public class PacketConfirmTransaction extends Packet {

	public byte id;
	public short action;
	public boolean confirm;

	public PacketConfirmTransaction() {
	}

	public PacketConfirmTransaction(byte id, short action, boolean confirm) {
		this.id = id;
		this.action = action;
		this.confirm = confirm;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.id = in.readByte();
		this.action = in.readShort();
		this.confirm = in.readBoolean();
	}

	@Override
	public void write(NetOutput out) throws IOException {
		out.writeByte(this.id);
		out.writeShort(this.action);
		out.writeBoolean(this.confirm);
	}

	@Override
	public void handleClient(Client conn) {
	}

	@Override
	public void handleServer(ServerConnection conn) {
	}

	@Override
	public int getId() {
		return 106;
	}

	@Override
	public void accept(PacketVisitor visitor) {
		visitor.visit(this);
	}

}