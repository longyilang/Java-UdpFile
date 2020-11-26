package com.lyl.udpfile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	
	public static void main(String[] args) {
		byte[] datas = fileToByteArray("ex_guide.png");
		System.out.println(datas.length);
		ByteArrayToFile(datas, "test.png");
	}
	
	public  static byte[] fileToByteArray(String  filePath) {
		//1创建源与目的地
		File src = new File(filePath);
		byte[] dest = null;
		//2选择流
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//3操作(分段读取)
			byte[] flush = new byte[1024*10];
			int len = -1;
			while ((len=is.read(flush)) != -1) {
				baos.write(flush,0,len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(is, baos);
		}
		return null;
	}
	
	public  static void ByteArrayToFile(byte[] src, String filePath) {
		//1创建源
		File dest = new File(filePath);
		//2选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest,true);
			//3操作（分段读取）
			byte[] flush = new byte[5];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(is, os);
		}
	}
	
	public static void close(InputStream is, OutputStream  os) {
		try {
			if (null != is) {
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (null != os) {
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
