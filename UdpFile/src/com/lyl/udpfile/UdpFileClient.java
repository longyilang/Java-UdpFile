package com.lyl.udpfile;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * 文件发送方
 */

public class UdpFileClient {
	public static void main(String[] args) throws SocketException {
		System.out.println("发送方启动...");
		DatagramSocket client = new DatagramSocket(8888);
		byte[] datas = IOUtils.fileToByteArray("test.png");
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		try {
			client.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
	}
}
