package com.lyl.udp;


/*UDP基本操作*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
	public static void main(String[] args) throws SocketException {
		System.out.println("发送方启动中");
		DatagramSocket client = new DatagramSocket(8888);
		String string = "马克思列宁主义";
		byte[] data = string.getBytes();
		DatagramPacket packet = new DatagramPacket(data, 0, data.length, new InetSocketAddress("localhost", 9999));
		try {
			client.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
	}
}
