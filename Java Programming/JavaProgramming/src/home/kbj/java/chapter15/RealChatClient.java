package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class RealChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient cc = new ChatClient("127.0.0.1", 9999);
		cc.execute();

	}

}

class ChatClient {
	private String serverIP;
	private int serverPort;
	
	ChatClient(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	void execute() {
		try (
				Socket socket = new Socket(serverIP, serverPort);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				Scanner sc = new Scanner(System.in);
		) {
			// receive
			Thread t = new Thread(new ReceiveClientThread(socket));
			t.start();
			
			// send
			String sendMessage = null;
			while(true) {
				if("bye".equals(sendMessage))
					break;
				System.out.print("Send>>");
				sendMessage = sc.nextLine();
				bw.write(sendMessage + "\n");
				bw.flush();
				System.out.printf("Client : %s\n", sendMessage);
			}
		}
		catch (Exception e) {
			System.exit(1);
		}
		
	}
}

class ReceiveClientThread implements Runnable {
	private Socket socket;
	
	ReceiveClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try (
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			) {
				String line;
				while((line = br.readLine()) != null) {
					if("bye".equals(line)) {
						break;
					}
					System.out.printf("\nServer : %s\n", line);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	}

}


