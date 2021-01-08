package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {
	
	public static void main(String[] args) {
		CreateClient chattingClient = new CreateClient("127.0.0.1", 9999);
		chattingClient.execute();
	}
}

class CreateClient {
	private String serverIP;
	private int serverPort;
	
	CreateClient(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	void execute() {
		try (
				Socket socket = new Socket(serverIP, serverPort);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				Scanner sc = new Scanner(System.in);
		) {
			while(true) {
				System.out.print("Send>>");
				String sendMessage = sc.nextLine();
				if("bye".equals(sendMessage)) {
					bw.write(sendMessage + "\n");
					bw.flush();
					break;
				}
				bw.write(sendMessage + "\n");
				bw.flush();
				
				System.out.printf("Server: %s \n", br.readLine());
			}
		}
		catch (IOException e) {
			System.out.println("Failed to connect client socket");
			e.printStackTrace();
		}
	}
	
	
}

/* result
 * 보내기>>안녕?
 * 서버: 너도 안녕?
 * 보내기>>bye
 */