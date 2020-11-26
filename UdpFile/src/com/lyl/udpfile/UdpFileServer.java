package com.lyl.udpfile;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 文件接收方
 */

public class UdpFileServer {
	public static void main(String[] args) throws SocketException {
		System.out.println("接收方启动...");
		DatagramSocket server = new DatagramSocket(9999);
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
		IOUtils.ByteArrayToFile(datas, "src/copy.png");
		server.close();
	}
}
