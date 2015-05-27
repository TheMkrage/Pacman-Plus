package org.mrflark.pacmanplus.multiplayer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Player1 {

	private int x, y, dx, dy;

	private int port;
	private InetAddress ip;
	private DatagramSocket socket;

	public Player1(String ipString, int port) throws Exception {
		socket = new DatagramSocket();
		ip = InetAddress.getByName(ipString);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setDX(int dx) {
		this.dx = dx;
	}

	public void setDY(int dy) {
		this.dy = dy;
	}

	public void move() {

		x += dx;
		y += dy;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(new Packet(x, y));
			oos.flush();
			oos.close();
			baos.flush();
			byte[] data = baos.toByteArray();
			baos.close();
			DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}