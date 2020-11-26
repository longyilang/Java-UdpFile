package com.lyl.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
	public static void main(String[] args) throws SocketException {
		System.out.println("接收方启动中...");
		DatagramSocket server = new  DatagramSocket(9999);
		
		byte[] container = new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
		try {
			server.receive(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas,0,len));
	}
}
