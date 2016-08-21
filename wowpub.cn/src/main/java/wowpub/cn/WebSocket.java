package wowpub.cn;
import java.net.*;
import java.io.*;

public class WebSocket {
	static public void sendData(String data){
		try{
			Socket socket = new Socket("120.76.120.122", 10001);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			//dos.writeUTF(data);
			dos.writeInt(1);
			socket.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
