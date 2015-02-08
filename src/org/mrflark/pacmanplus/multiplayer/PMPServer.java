package org.mrflark.pacmanplus.multiplayer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PMPServer extends DatagramSocket implements Runnable {

	private Player2 p2;

	public PMPServer(int port, Player2 p2) throws IOException {
		super(port);
		new Thread(this).start();
	}

	public void run() {
		try {
			while (true) {
				byte[] get = new byte[2048];
				DatagramPacket packet = new DatagramPacket(get, get.length);
				receive(packet);
				ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
				ObjectInputStream ois = new ObjectInputStream(bais);
				Packet p = (Packet) ois.readObject();
				ois.close();
				bais.close();
				p2.setX(p.getX());
				p2.setY(p.getY());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}